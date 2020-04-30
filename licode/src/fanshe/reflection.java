package fanshe;

import org.junit.Test;
import paixu.Mouse;

/**
 * @author jing
 * @create 2020-03-01-9:51
 */
public class reflection {
    @Test
    public void test() throws ClassNotFoundException {
        // 通过类的属性
        Class<Mouse> aClass = Mouse.class;
        System.out.println(aClass);
        // 通过运行时类
        Mouse mouse = new Mouse();
        Class<? extends Mouse> aClass1 = mouse.getClass();
        System.out.println(aClass1);
        // 通过Class的静态方法 类的全雷鸣
        Class<?> aClass2 = Class.forName("paixu.Mouse");  //比较多
        System.out.println(aClass2);
        // 他们都是同一个  因为你一个类 本身就是概念 一个模版  所以加载到内存就一份就行了
        // 这不单是一个类 还是运行时类  而且还不是创建 你夹在内存已经有了  所以这叫加载获取
        // 类的加载器 ClassLoader
        ClassLoader loader = reflection.class.getClassLoader();
        Class<?> aClass3 = loader.loadClass("paixu.Mouse");
        System.out.println(aClass3);
    }
}
