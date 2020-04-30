package fanshe;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jing
 * @create 2020-03-01-16:24
 */
public class fieldTest {
    @Test
    public void test1() throws Exception{
        Class<person> aClass = person.class;
        Field id = aClass.getField("id"); // 只能找到public权限 父类子类
        // 但是属性一般要私有 所以用的比较少
        person person = aClass.newInstance();
        id.set(person,1000);
        Object o = id.get(person);
        System.out.println(o);
    }
    @Test
    public void test2() throws Exception{
        // 如何操作运行时类的属性
        Class<person> aClass = person.class;
        person person = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        // 保证当前属性是可以访问的
        name.setAccessible(true);
        // 获取设置私有属性值
        name.set(person,"tom");
        System.out.println(name.get(person));
    }
    @Test
    public void test3() throws Exception{
        // 如何操作运行时类的方法
        Class<person> aClass = person.class;
        person person = aClass.newInstance();
        Method show = aClass.getDeclaredMethod("show", String.class, int.class);
        show.setAccessible(true);
        System.out.println(show.invoke(person, "1", 12));
        // 调用静态方法
    }
    @Test
    public void test4() throws Exception{
        // 调用静态方法
        Class<person> aClass = person.class;
        Method show = aClass.getDeclaredMethod("show1", String.class, int.class);
        show.setAccessible(true);
        Object o = show.invoke(aClass, "2", 22);
        System.out.println(o);
    }
    @Test
    public void test5() throws Exception{
        // 调用其他的有参数的构造器
        Class<person> aClass = person.class;
        Constructor<person> dc = aClass.getDeclaredConstructor(String.class);
        dc.setAccessible(true);
        person person = dc.newInstance("1");
        System.out.println(person);
    }
    @Test
    public void test6() throws Exception{
        // 反射
        ClassLoader loader = fieldTest.class.getClassLoader();
        Class<?> aClass = loader.loadClass("fanshe.person");
        person p = (person)aClass.newInstance();
        Method show = aClass.getDeclaredMethod("show1", String.class, int.class);
        show.setAccessible(true);
        show.invoke(p,"1",5);
    }
}
