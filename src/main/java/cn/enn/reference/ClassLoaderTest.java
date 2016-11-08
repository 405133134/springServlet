package cn.enn.reference;

import java.net.URLClassLoader;
import java.util.Date;
import java.util.List;

import com.sun.nio.zipfs.ZipFileAttributes;

import sun.misc.Launcher;

public class ClassLoaderTest {

	public static void main(String[] args) {
        System.out.println("ClassLoaderText类的加载器的名称:"+ClassLoaderTest.class.getClassLoader().getClass().getName());  
        System.out.println("System类的加载器的名称:"+System.class.getClassLoader());  
        System.out.println("List类的加载器的名称:"+List.class.getClassLoader());  
        System.out.println("ZipFileAttributes类的加载器的名称:"+ZipFileAttributes.class.getClassLoader());  
        System.out.println("默认类的加载器:"+ClassLoaderTest.class.getClassLoader().getSystemClassLoader());  

        ClassLoader cl = ClassLoaderTest.class.getClassLoader();  
        while(cl != null){  
            System.out.print(cl.getClass().getName()+"->");  
            cl = cl.getParent();  
        }  
        System.out.println(cl); 
        
        try {  
            Class classDate = new MyClassLoader("D:/workspace/springServlet/class_temp").loadClass("ClassLoaderAttachment");  
            Date date = (Date) classDate.newInstance();  
            //输出ClassLoaderAttachment类的加载器名称  
            System.out.println("ClassLoader:"+date.getClass().getClassLoader().getClass().getName());  
            System.out.println("ClassLoader:"+date.getClass().getClassLoader().getParent());  
            System.out.println(date);  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        }  

	}

}
