package com.guoguo.javaAudition.classLoader;

import java.io.*;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-04 11:40
 */
public class MyClassLoader extends ClassLoader {

    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }


    @Override
    public Class findClass(String name){
        byte[] b = loadClassData(name);
        return defineClass(name , b , 0 , b.length);
    }

    private byte[] loadClassData(String name) {
        name = this.path +name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i = 0;
            while (( i = in.read()) != -1){
                out.write(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }


}