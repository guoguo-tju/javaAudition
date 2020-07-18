package com.guoguo.javaAudition.job;

import com.sun.corba.se.spi.orb.ParserImplBase;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xalan.internal.xsltc.dom.SingleNodeCounter;

import java.util.Collection;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-26 17:12
 */
public class ParamUtils {


    public static final char DELIM_START = '{';
    public static final char DELIM_STOP = '}';


    /**
     * 格式化字符串 , 使用sl4j占位服的方式格式化字符串
     * @param messagePattern
     * @param args
     * @return
     */
    public static String format(String messagePattern , Object... args){
        if (messagePattern == null){
            return "";
        }
        if (args.length == 0){
            return messagePattern;
        }
        int i = 0;
        int len = messagePattern.length();
        int j;
        StringBuilder sbuf = new StringBuilder(messagePattern.length() +50);

        for (int L = 0; L < args.length; L++) {

            char escape = 'x';

            j = messagePattern.indexOf(DELIM_START ,i);

            if (j == -1 || (j + 1 == len)){

                if (i == 0 ){
                    return messagePattern;
                }else {
                    sbuf.append(messagePattern.substring(i , messagePattern.length()));
                    return sbuf.toString();
                }
            } else {
                char delimStop = messagePattern.charAt( j + 1);
                if (j > 0){
                    escape = messagePattern.charAt(j - 1);
                }
                if (escape == '\\'){
                    L--;
                    sbuf.append(messagePattern.substring(i , j-1));
                    sbuf.append(DELIM_START);
                    i = j + 1;
                }else if ((delimStop != DELIM_STOP)){
                    sbuf.append(messagePattern.substring(i , messagePattern.length()));
                }else {
                    sbuf.append(messagePattern.substring(i,j));
                    sbuf.append(args[L]);
                    i = j + 2 ;
                }
            }
        }
        sbuf.append(messagePattern.substring(i , messagePattern.length()));
        return sbuf.toString();
    }

    /**
     * 校验是否为true , 非true将抛出 IllegalParamException
     * @param param
     * @param format
     * @param args
     */
    static public void assertTrue(boolean param , String format , Object... args){
        if (!param){
            String msg = format(format , args);
//            Log.error(LOGGER , "{}" , msg);
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 断言为null , 非null将抛出异常
     * @param param
     * @param format
     * @param args
     */
    static public void assertNull(Object param , String format , Object... args){
        assertTrue(param == null , format , args);
    }


    /**
     * 断言不为null , 为null将抛出异常
     * @param param
     * @param format
     * @param args
     */
    static public void assertNotNull(Object param , String format , Object... args){
        assertTrue(param != null , format , args);
    }

    /**
     * 断言集合不为null
     * @param collection
     * @param format
     * @param args
     */
    static public void assertNotEmpty(Collection<?> collection , String format , Object... args){
        assertTrue(collection != null && collection.isEmpty() , format , args);
    }


    public static void main(String[] args) {
        System.out.println(ParamUtils.format("id={},name={},age={}", 110 , "karl" , 18));
    }

}