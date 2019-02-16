package com.guoguo.javaAudition.exception;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-16 18:10
 */
public class ExceptionTest {

    public static void main(String[] args) {

        int i = dowork();
        System.out.println(i);
    }

    private static int dowork() {
        try {
            int i = 10 / 0;
            System.out.println("i = " + i);
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException " + e);
            return 0;
        }catch (Exception e){
            System.out.println("Exception " + e);
            return 1;
        }finally {
            System.out.println("finally");
            return 2;
        }
    }


}