package com.guoguo.javaAudition.job.machine;

import com.guoguo.javaAudition.example.TransactionTemplateService;
import com.guoguo.javaAudition.job.TimeCallbackService;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-28 16:50
 */
@Service
public class MachineServiceImpl implements MachineService , ApplicationRunner{

    /**
     * 心跳间隔 , 单位分钟
     */
    private static final int HEARTBEAT_INTERVAL = 2;

    /**
     * 宕机标准: 无心跳时间 , 单位秒
     */
    private static final int NO_HEARTBEAT_TIME_BEFORE_DEATH = 60 * 10;


    private final Map<String , Consumer<Machine>> callbckDict = new HashMap<>();

    @Autowired
    private TimeCallbackService timeCallbackService;

    @Autowired
    private TransactionTemplateService transactionTemplateService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 启动时先记录一次心跳
        recordHeartbeat();
        timeCallbackService.runAfter(this::heartbeat , HEARTBEAT_INTERVAL , TimeUnit.MINUTES , false);

    }



    @Override
    public void registerDowntimeMigrationCallback(String key, Consumer<Machine> callback) {
        this.callbckDict.put(key , callback);
    }

    /**
     * 执行一次心跳
     */
    @Override
    public void heartbeat() {
        try {
            // 记录当前机器心跳
            recordHeartbeat();

            // 扫描宕机机器
            scanDeadMachines();



        }catch (Exception e){

        }finally {
            timeCallbackService.runAfter(this::heartbeat , HEARTBEAT_INTERVAL , TimeUnit.MINUTES , false);
        }
    }


    /**
     * 扫描宕机机器
     */
    private void scanDeadMachines() {

//      List<Machine> machineList =  machineMapper.queryByEnvAndStatus("env" , "RUNNING");
        List<Machine> machineList = null;
        // 获取数据库中本机的当前心跳时间作为比较基准

        // 从machineList中根据machine找到本机
        Machine selfMachine = null;
        Date currentTime = selfMachine.getLastHeartbeat();

        // 找出已经宕机的机器进行迁移
        machineList.stream()
                .filter(machine -> isDeadMachine(machine , currentTime))
                .forEach(machine -> migrateDeadMachine(machine , selfMachine));
    }


    /**
     * 进行宕机迁移
     * @param machine
     * @param selfMachine
     */
    private void migrateDeadMachine(Machine machine, Machine selfMachine) {
        transactionTemplateService.tx(()->{

            Machine target = null;
            // select * from machine where machine=#{machine} and env=#{env} limit 1 for update
//            machineMapper.getMachineWithLock(machine.getMachine() , machine.getEnv());

            // 重新检查确保没有被其他机器迁移了
            if (target.getStatus() == "RUNNING"){
                // 目标机器已经被其他机器迁移
                return null;
            }

            // 重新检查确定目标机器没有存活
            if (!isDeadMachine(target , selfMachine.getLastHeartbeat())){
                // 目标机器已经复活,无需迁移
                return null;
            }

            // 标记目标机器将由本机负责迁移
            // update machine set status='DEAD', migrate_machine=#{migrateMachine},
            //     gmt_modified=CURRENT_TIMESTAMP where machine=#{machine} and env=#{env}
//            machineMapper.markMigrated(target.getMachine() , target.getEnv() , selfMachine.getMachine());

            // 调用回调执行具体的宕机迁移逻辑
            callbckDict.values().forEach(callback-> callback.accept(target));
            return null;
        });


    }


    /**
     * 判断是否宕机
     * @param machine
     * @param currentTime
     * @return
     */
    private boolean isDeadMachine(Machine machine, Date currentTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(currentTime);
        c.add(Calendar.SECOND , -NO_HEARTBEAT_TIME_BEFORE_DEATH);
        return machine.getLastHeartbeat().before(c.getTime());
    }


    /**
     * 记录心跳
     */
    private void recordHeartbeat() {
        transactionTemplateService.tx(()->{
            // select * from machine where machine=#{machine} and env=#{env} limit 1 for update
//           Machine machine =  machineMapper.getMachineWithLock("machine" , "env");
            Machine machine = null;
            if (machine == null){
                Machine newMachine = new Machine();
                newMachine.setMachine("machine");
                newMachine.setEnv("env");
                newMachine.setStatus("RUNNING");
//                machineMapper.insert(newMachine);
            }else {
                // update machine set gmt_modified=CURRENT_TIMESTAMP, last_heartbeat=CURRENT_TIMESTAMP,
                //    status='RUNNING', migrate_machine=null
                //    where machine=#{machine} and env=#{env}

//                machineMapper.recordHeartbeat("machine","env");
            }
            return null;
        });
    }



}