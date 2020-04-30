package dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jing
 * @create 2020-03-01-22:03
 */
interface human {
    String getBelief();

    void eat(String food);
}

// 被代理类
class superman implements human {
    @Override
    public String getBelief() {
        return "我的信仰是黑暗之魂";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人吃东西" + food);
    }
}

class myInvoke implements InvocationHandler {
    private Object object;

    public void bind(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}

// 创建一个代理类
class proxyFactory {
    public static Object getProxyInstance(Object o) {
        myInvoke myInvoke = new myInvoke();
        myInvoke.bind(o);
        // 通过调用此方法 返回一个代理类对象
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),
                o.getClass().getInterfaces(), myInvoke);
    }
}

public class proxy {
    public static void main(String[] args) {
        superman superman = new superman();
        human instance = (human) proxyFactory.getProxyInstance(superman);
        String belief = instance.getBelief();
        System.out.println(belief);
        instance.eat("西瓜");

    }
}
