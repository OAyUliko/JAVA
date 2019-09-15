package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//-----------------------得到字节码中的成员方法对象 Method
public class test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz=Class.forName("demo.Person2");//1.得到字节码文件对象
        //Method[] methods= clazz.getMethods();//不管是父类继承下来的，还是自身的，public的，都可以显示出来
        //for(Method method:methods)//增强型的for循环。Method是元素类型,method是每一个元素变量，methods是你要遍历的数组
        //System.out.println(method);
        Method method=clazz.getMethod("setName",String.class);//2.得到特定的方法 要知道方法名+形参
        System.out.println(method);
        //调用的传统方法是对象.方法（对象），但反射里面是：方法.invoke（对象，实参）
        // Constructor constructor=clazz.getConstructor(); 用构造器去创建实例
        //Object newInstance=constructor.newInstance();
        Object newInstance=clazz.newInstance();//3.创建方法所在类的对象.这是更便捷的方法去创建类的对象，但只针对无参数的方法
        //        //4.反射调用
        Object a=method.invoke(newInstance,"haha");
        System.out.println(a);
    }
}
