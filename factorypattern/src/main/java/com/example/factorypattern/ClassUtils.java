package com.example.factorypattern;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by yangjun on 2016/5/31.
 */
public class ClassUtils {
    /**
     * @description 指定一个接口，返回这个接口所有实现类
     * @author yangjun 2016/5/31 15:47
     *
     */
    public static List<Class> getAllClassByInterface(Class c){
        ArrayList<Class> returnClass = new ArrayList<Class>();
        // 如果是接口才处理
        boolean anInterface = c.isInterface();
        LogFactory.log("anInterface = "+anInterface);
        if(anInterface){
            String packageName = c.getPackage().getName(); //获取当前包名
            LogFactory.log("packageName = "+packageName);
            try {
                List<Class> allClass = getClasses(packageName);
                int size = allClass.size();
                LogFactory.log("allclass size = "+size);
                if (0 != size){
                    for (int i = 0;i<size;i++){
                        // 判断 c 是否 和 allClass.get(i) 相同，是否为同一个接口
                        if (c.isAssignableFrom(allClass.get(i))){
                            if (!c.equals(allClass.get(i))){     // 本身不加入
                                returnClass.add(allClass.get(i));
                            }

                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return returnClass;

    }
    private static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {
        //http://www.blogjava.net/lihuaxajh/articles/94371.html
        // 这个是一个线程加载器，可以实现双向加载，即由子类向父类，也可由父类向子类加载
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
//        String path1 = packageName.replace('.', '//');
        File file1 = new File(path);
        String absolutePath = file1.getAbsolutePath();
        LogFactory.log("absolutePath = "+absolutePath);
        LogFactory.log("path = " + path);
        URL resource3 = classLoader.getResource(absolutePath);
        URL resource1 = classLoader.getResource("");
        URL resource2 = classLoader.getResource("/");
        LogFactory.log("resource1 = "+resource1);
        LogFactory.log("resource2 = "+resource2);
        LogFactory.log("resource3 = "+resource3);
        Enumeration<URL> resources = classLoader.getResources(path);
        LogFactory.log("resources = "+resources);
        ArrayList<File> dirs = new ArrayList<>();
        boolean b = resources.hasMoreElements();
        LogFactory.log("b = "+b);
        while (b){
            URL resource = resources.nextElement();
            String file = resource.getFile();
            dirs.add(new File(file));
        }
        ArrayList<Class> classes = new ArrayList<>();
        int size = dirs.size();
        if(0 != size){
            for (File directory : dirs){
                List<Class> classes1 = findClasses(directory, packageName);
                LogFactory.log("classes1 = " + classes1);
                if(0 != classes1.size()){
                    classes.addAll(classes1);
                }
            }
        }
        return classes;
    }
    private static List<Class> findClasses(File directory,String packageName) throws ClassNotFoundException {
        LogFactory.log("findClasses is start directory = "+directory.toString());
        ArrayList<Class> classes = new ArrayList<>();
        boolean exists = directory.exists();
        LogFactory.log("exists = "+exists);
        if(!exists){
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files){
            if(file.isDirectory()){
                assert !file.getName().contains(".");   //表示断言，如果为false则终止程序，报assertError 。http://lavasoft.blog.51cto.com/62575/43735
                classes.addAll(findClasses(file,packageName+"."+file.getName()));
            }else if (file.getName().endsWith(".class")){
                Class<?> aClass = Class.forName(packageName + "." + file.getName());
                classes.add(aClass);
            }
        }
        return classes;
    }
}
