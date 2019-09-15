package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//-----------------------得到字节码中的构造方法对象 Constructor
public class test {
    public static void  main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz=Class.forName("demo.Person2");
        Constructor[] constructors1=clazz.getConstructors();
        System.out.println(constructors1.length);//结果是1，表明getConstructors（）只得到public的构造方法
        Constructor[] constructors2=clazz.getDeclaredConstructors();
        System.out.println(constructors2.length);//结果是4，是全部的构造方法

        //-----------------构造器的访问权限测试-----------------
        Constructor constructors3=clazz.getConstructor(String.class,int.class);//public Person2(String name,int age)
        Object newInstance3=constructors3.newInstance("meiko",21);
        System.out.println(newInstance3);

        Constructor constructors4=clazz.getDeclaredConstructor();//private Person2()
        constructors4.setAccessible(true);//暴力访问放前面
        Object newInstance4=constructors4.newInstance();
        System.out.println(newInstance4);

        Constructor constructors5=clazz.getDeclaredConstructor(String.class);// Person2(String name)
        Object newInstance5=constructors5.newInstance("meiko");
        System.out.println(newInstance5);//结果是：protected demo.Person2(int)
        //public getConstructor
        //private getDeclaredConstructor+暴力访问
        //无符号 protected getDeclaredConstructor
        //输出结果是：
        // Person2{name='meiko', age=21}
        //Person2{name='null', age=0}
        //Person2{name='meiko', age=0}
    }
}
