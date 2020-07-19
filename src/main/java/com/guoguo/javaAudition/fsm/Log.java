package com.guoguo.javaAudition.fsm;

import com.google.common.base.Throwables;
import com.guoguo.javaAudition.job.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.LockInfo;
import java.util.logging.Level;

/**
 * 描述:
 *
 *   日志工具类
 *
 * @author guozh
 * @create 2020-07-18 23:03
 */
public class Log {

    public static final Logger LOGGER = LoggerFactory.getLogger(Log.class);

    public static java.util.logging.Logger testLogger = java.util.logging.Logger.getGlobal();

    /**
     * 标明是否是测试
     */
    private static boolean isTest = false;


    /**
     * 使用指定的logger记录info级别日志
     * @param logger
     * @param format
     * @param args
     */
    public static void info(Logger logger , String format , Object... args){

        if (isTest){
            testLogger.info(ParamUtils.format(format , args));
            return;
        }
        if (logger.isInfoEnabled()){
            logger.info(ParamUtils.format("[{}]-" + format , getTraceId()) , args);
        }
    }


    /**
     * 使用指定的logger记录error级别日志
     * @param logger
     * @param format
     * @param args
     */
    public static void error(Logger logger , String format , Object... args){
        if (isTest){
            testLogger.log(Level.WARNING, ParamUtils.format(format , args));
            return;
        }
        logger.error(ParamUtils.format("[{}]-" + format , getTraceId()), args);
    }

    /**
     * 先打印异常描述,再打印堆栈
     * @return
     */
    public static void error(Logger logger , Throwable t , String msg , Object... args){
        if (isTest){
            testLogger.log(Level.WARNING , ParamUtils.format(msg , args));
            return;
        }
        error(logger , msg ,args);
        String stack = Throwables.getStackTraceAsString(t);
        error(logger , stack);
    }


    /**
     * 使用debug级别的日志
     * @return
     */
    public static void debug(Logger logger , String format , Object... args){
        if (logger.isDebugEnabled()){
            logger.debug(format , args);
        }
    }




    private static Object getTraceId() {
        // 获取rpc的traceId

        // 没有的话用线程信息
        String threadId = String.valueOf(Thread.currentThread().getId());
        if (threadId != null){
            return threadId;
        }
        return "null";
    }



}