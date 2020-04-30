package dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jing
 * @create 2020-03-01-22:21
 */
interface email{
    String send();
    String get(int num);
}
// 创建被代理类
class person implements email{
    @Override
    public String send() {
        return "我要send发了";
    }

    @Override
    public String get(int num) {
        return "我收到了"+num;
    }
}
// 创建代理类
class worker{
    public static Object getWorkerInstance(Object o){
        myHandler handler = new myHandler();
        handler.bind(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),
                o.getClass().getInterfaces(), handler);
    }
}
class myHandler implements InvocationHandler {
    Object object;
    public void bind(Object o){
        this.object=o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object,args);
    }
}
public class test {
    public static void main(String[] args) {
        person person = new person();
        superman superman = new superman();
        human instance = (human) worker.getWorkerInstance(superman);
        instance.eat("dd");
//        email instance = (email) worker.getWorkerInstance(person);
//        String s = instance.get(5);
//        System.out.println(s);
    }
}
