package com.guoguo.javaAudition.job;

import com.sun.corba.se.spi.orb.ParserImplBase;
import com.sun.org.apache.regexp.internal.RE;

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


    public static void main(String[] args) {
        System.out.println(ParamUtils.format("id={},name={},age={}", 110 , "karl" , 18));
    }

}