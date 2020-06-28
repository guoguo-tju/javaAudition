package com.guoguo.javaAudition.job;

import com.alibaba.fastjson.JSON;
import com.guoguo.javaAudition.example.TransactionTemplateService;
import com.guoguo.javaAudition.example.TransactionTemplateServiceImpl;
import com.guoguo.javaAudition.job.machine.Machine;
import com.guoguo.javaAudition.job.machine.MachineService;
import com.sun.security.sasl.ntlm.FactoryImpl;
import jdk.internal.util.EnvUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-28 11:55
 */
@Service
public class JobServiceImpl implements JobService , ApplicationRunner {

    @Autowired
    private TimeCallbackService timeCallbackService;

    @Autowired
    private TransactionTemplateService transactionTemplateService;

    @Autowired
    private JobExecutors jobExecutors;

    @Autowired
    private MachineService machineService;


    private static final Logger LOGGER = LoggerFactory.getLogger(JobServiceImpl.class);

    private static int MAX_RETRY_TIME = 35;


    @Override
    public void submitJob(Job job) {
        try {
//            jobMapper.insert(job);
        }catch (Exception e){

        }

    }

    @Override
    public void submitUpdateResultJob(TaskResult taskResult) {
        String jobId = ParamUtils.format("J-{}-{}-{}" , JobType.UPDATE_BPM , taskResult.getTaskId(),taskResult.getTaskId());
        Job job = new Job();
        job.setJobId(jobId);
        job.setParam(JSON.toJSONString(taskResult));
        job.setType(JobType.UPDATE_BPM.name());
        job.setMachine("");
        job.setExecTime(new Date());
        job.setRetryTime(3);
        job.setExecInterval(1000);
        job.setStatus(0);
        submitJob(job);
    }




    /**
     * 项目启动完成之后调用
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 注册宕机迁移回调
        machineService.registerDowntimeMigrationCallback("MIGRATE_JOB" , this::migrateMachine);

        // 启动定时任务 , 扫描整个组件进行处理
        timeCallbackService.runAfter(SCANNER , 3 , TimeUnit.SECONDS , false);
    }

    /**
     * job任务宕机迁移逻辑
     * @param machine
     */
    private void migrateMachine(Machine machine) {
        String failedMachineName = machine.getMachine();
        String selfMachineName = "selfMachine";

        transactionTemplateService.tx(()->{
            // 宕机机器下的job任务加锁
            // select * from job where machine=#{machine} and exec_time < #{execTime} and status = 0 for update
//            jobMapper.getselfJobWithLock(failedMachineName , new Date());

            // 迁移宕机机器的job到本机
            // update job set machine=#{selfMachineName} , gmt_modified=CURRENT_TIMESTAMP where machine=#{failedMachineName}
//            jobMapper.migrateMachine(failedMachineName , selfMachineName);
        });

    }


    private final Runnable SCANNER = new  Runnable(){

        @Override
        public void run() {
            try {
                List<Job> jobs = queryJobs();
                for (Job job : jobs) {
                    Boolean res = false;
                    try {
                        if (JobType.ITEM_START.name().equals(job.getType())){
                           res = doItemTaskStart(job);
                        }else if (JobType.ITEM_FINISH.name().equals(job.getType())){
                            res = doItemTaskFinish(job);
                        }else if (JobType.UPDATE_BPM.name().equals(job.getType())){
                            res = doUpdateStatus(job);
                        }

                        if (res == false){
                            // 更新下一次执行信息
                            updateNextExecInfo(job);
                        }
                    }catch (Exception e){
                        // 打印日志
                    }
                }

            }finally {
                timeCallbackService.runAfter(SCANNER , 300 , TimeUnit.MILLISECONDS , false);
            }

        }
    };

    private void updateNextExecInfo(Job job) {

        int status = job.getStatus();
        int retryTime = job.getRetryTime();

        if (job.getExecInterval() > 0){
            long nextExecTime = System.currentTimeMillis() + job.getExecInterval();
            retryTime = job.getRetryTime() + 1;
            if (retryTime > MAX_RETRY_TIME){
                status = 1;
            }
//            jobMapper.updateExecTime(job.getId(),retryTime,nextExecTime,status);

        }else {
            retryTime = job.getRetryTime() + 1;
            long nextExecTime = System.currentTimeMillis() + 1000 * job.getRetryTime();
            if (retryTime > MAX_RETRY_TIME){
                status = 1;
            }
//            jobMapper.updateExecTime(job.getId(),retryTime,nextExecTime,status);
        }
        job.setStatus(status);

        // 超过最大重试次数时发消息
        if (retryTime == MAX_RETRY_TIME + 1){
//            sendMessage();
        }

    }

    // 更改task状态使用
    private Boolean doUpdateStatus(Job job) {
        return transactionTemplateService.tx(
                new TransactionTemplateServiceImpl.Exector<Boolean>() {
                    @Override
                    public Boolean onFailed(Exception e) {
//                        jobMapper.lock(job.getId());

                        // 从参数中获取taskResult并处理

                        // 删除job


                        return true;
                    }

                    @Override
                    public Boolean call() throws Exception {
                        return false;
                    }
                }
        );

    }

    // 调用executor来轮询结果
    private Boolean doItemTaskFinish(Job job) {
       return transactionTemplateService.tx(
                new TransactionTemplateServiceImpl.Exector<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {

//                        jobMapper.lock(job.getId());
                        String processorType = job.getProcessorType();
                        JobExecutor executor = jobExecutors.getExecutor(processorType);

                        boolean res = executor.doJob(job);

                        if (res){
                            // 轮询到结果了 , 不需要再执行了 , 删除job

                            return true;
                        }else {
                            // 未查询到结果,需要继续执行

                            // 是否超过了最大次数
                            int retryTime = job.getRetryTime() + 1;
                            if (retryTime > MAX_RETRY_TIME){
                                // 将task置为失败

                                // 删除job
                                return true;
                            }
                            return false;

                        }
                    }

                    @Override
                    public Boolean onFailed(Exception e) {
                        handleJobProcessException(job);
                        return false;
                    }
                }

        );


    }

    private Boolean doItemTaskStart(Job job) {
       return  transactionTemplateService.tx(
                new TransactionTemplateServiceImpl.Exector<Boolean>() {


                    @Override
                    public Boolean call() throws Exception {

                        //select * form job where id = #{id} for update
//                        jobMapper.lock(job.getId());


                        // 业务逻辑

                        // 删除job

                        return true;
                    }

                    @Override
                    public Boolean onFailed(Exception e) {
                        handleJobProcessException(job);
                        return false;
                    }
                }


        );

    }

    /**
     * 针对最后一次执行失败的时候 , 抛了异常 , 导致任务不能停下来的情况 , 需要进行这样一次处理
     * @param job
     */
    private void handleJobProcessException(Job job) {
        transactionTemplateService.tx(
                new TransactionTemplateServiceImpl.Exector<Boolean>() {

                    @Override
                    public Boolean call() throws Exception {
//                        jobMapper.lock(job.getId());
                        int retryTime = job.getRetryTime() + 1;
                        if (retryTime > MAX_RETRY_TIME){
                            // 将task置为失败状态

                            // 删除job

                        }

                        return true;
                    }

                    @Override
                    public Boolean onFailed(Exception e) {
                        return false;
                    }
                }

        );

    }



    private List<Job> queryJobs() {
        // select * from job where machine = #{machine} and exec_time < #{execTime} and status = 0 for update
//        jobMapper.getSelfJobs(machine , new Date());
         return null;

    }
}