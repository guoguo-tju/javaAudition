package com.guoguo.javaAudition.common;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.slf4j.MDC;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 描述:
 *
 *  设置统一的线程执行上下问信息
 *
 * @author guozh
 * @create 2020-07-19 16:36
 */
public class OpsCtx {

    private static final ThreadLocal<OperationContext> CTX = new ThreadLocal<OperationContext>();

    /**
     * 应用启动时间
     */
    private static final String BOOTSTRAP_TIME;
    private static final AtomicLong COUNTER = new AtomicLong(1);

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmssSSS-");
        BOOTSTRAP_TIME = sdf.format(new Date());
    }

    private OpsCtx(){

    }

    /**
     * 设置当前线程上下文,并执行指定的逻辑
     */
    public static <T> T call(Operator operator , Callable<T> c) throws Exception{
        return runInCtx(new OperationContext(operator) , c);
    }


    public static <T> T runInCtx(final OperationContext context , Callable<T> c) throws Exception{
       final String requestId = "requestId";
       final String loginUserId = "loginUserId";
       try {
           CTX.set(context);
           MDC.put(requestId , context.requestId);
           MDC.put(loginUserId , (context.operator != null)? context.operator.getLoginName() : "UnsetUser");
           return c.call();
       }finally {
            CTX.remove();
            MDC.remove(requestId);
            MDC.remove(loginUserId);
       }
    }

    /**
     * 获取当前操作人
     */
    public static Operator getOperator(){
        OperationContext context = CTX.get();
        return context == null ? null : context.operator;
    }

    /**
     * 获取当前上下问缓存的操作数据
     */
    public static <T> T get(Class<T> clazz){
        OperationContext context = Preconditions.checkNotNull(CTX.get(), "操作上下文信息未设置!");
        return context.get(clazz);
    }


    /**
     * 获取当前上下文缓存的数据 , 如果数据未设置 , 则用loader重新获取并缓存
     */
    public static <T> T get(Class<T> clazz , Callable<T> loader){
        T t = get(clazz);
        if (t == null){
            try {
                t = loader.call();
                set(clazz , t);
            }catch (Exception e){
                throw new  RuntimeException(e);
            }
        }
        return t;
    }

    /**
     * 设置当前上下文的操作数据
     */
    public static <T> T set(Class<T> clazz , T value){
        OperationContext context = Preconditions.checkNotNull(CTX.get(), "操作上下文信息未设置!");
        return context.set(clazz , value);
    }


    public static <T> T remove(Class<T> clazz){
        OperationContext context = Preconditions.checkNotNull(CTX.get(), "操作上下文信息未设置!");
        return (T) context.ctx.remove(clazz);
    }



    /**
     * 操作上下文
     */
    private static class OperationContext {

        /**
         * 当前操作人
         */
        private final Operator operator;

        /**
         * 请求唯一标识
         */
        private final String requestId;

        /**
         * 请求范围内的缓存
         */
        private final Map<Class<?> , Object> ctx = Maps.newHashMap();


        public OperationContext(Operator operator) {
            this.operator = operator;
            this.requestId = BOOTSTRAP_TIME + getId();
        }

        OperationContext(OperationContext operationContext){
            this.operator = operationContext.operator;
            this.requestId = operationContext.requestId + "#" + getId();
        }


        /**
         * 在上下文中缓存指定类型的对象
         */
        public <T> T set(Class<T> clazz , T obj){
            Preconditions.checkNotNull(clazz , "clazz参数不允许为null");
            Object v = ctx.put(clazz, obj);
            return clazz.cast(v);
        }

        /**
         * 从上下文中获取缓存数据
         */
        public <T> T get(Class<T> clazz){
            Preconditions.checkNotNull(clazz , "clazz参数不允许为null");
            Object v = ctx.get(clazz);
            return clazz.cast(v);
        }

    }



    private static String getId() {
        return String.valueOf(COUNTER.getAndIncrement());
    }
}