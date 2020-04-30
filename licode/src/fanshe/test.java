package fanshe;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author jing
 * @create 2020-03-01-14:54
 */
public class test {
    @Test
    public void test1(){
        // 属性
        Class<person> aClass = person.class;
        Field[] fields = aClass.getFields(); // 返回自己和父类属性 有父类 但是只有public
        Field[] fields1 = aClass.getDeclaredFields(); // 获取当前类自己定义的所有属性 有private
        fields[1].getModifiers();// 获取修饰符
        fields[0].getType(); // 返回值类型
        fields[0].getName(); // 返回变量名字
    }
    @Test
    public void test2(){
        // 获取方法
        Class<person> aClass = person.class;
        Method[] methods = aClass.getMethods();// 获取对象的方法 当前类及其父类的public 方法
        aClass.getDeclaredMethods(); // 获取对象的所有方法  包括私有方法
    }
    @Test
    public void test3(){
        // 注解
        // 获取方法 的内部结构 权限修饰符 返回值类型 方法名字 参数名字  throw 异常
        Class<person> aClass = person.class;
        Annotation[] annotations = aClass.getAnnotations();// 获取方法上声明的注解
        Method[] methods = aClass.getMethods();
        methods[1].getModifiers(); // 修饰符
        methods[1].getReturnType(); // 返回值类型
        methods[1].getName(); //方法名字
        methods[1].getParameterTypes();// 参数类型
        Class<?>[] exceptionTypes = methods[1].getExceptionTypes();// 获取方法异常类型
    }
    @Test
    public void test4(){
        // 获取运行时类的父类
        Class<person> aClass = person.class;
        Class<? super person> superclass = aClass.getSuperclass();
        Type genericSuperclass = aClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
    @Test
    public void test5(){
        // 获取运行时类的父类
        Class<person> aClass = person.class;
        Class<?>[] interfaces = aClass.getInterfaces(); // 接口多实现 获取接口
        aClass.getSuperclass().getInterfaces(); // 获取父类结构
    }
    @Test
    public void test6(){
        // 获取运行时类所在的包
        Class<person> aClass = person.class;
        Package aPackage = aClass.getPackage(); //
        System.out.println(aPackage);
    }
    @Test
    public void test7(){
        // 获取运行时类 上的注解
        Class<person> aClass = person.class;
        Annotation[] annotations = aClass.getAnnotations();
    }
}
