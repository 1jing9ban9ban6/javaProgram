package fanshe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyDemo {//    类加载器， 类数组，重写invoke方法
  public static void main(String[] args) {

      LoginService o = (LoginService) Proxy.newProxyInstance(LoginService.class.getClassLoader(),
              new Class<?>[] {LoginService.class}, new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args)
                  throws Throwable {
              if (method.getName().equals("say")) {
                  System.out.println("我是动态代理，但是不知道干啥"+args[0]);
              }
              if (method.getName().equals("eat")) {}

              if (method.getName().equals("say1")) {}

              return null;
          }
      });
      String a = "a";
      o.say(a);
  }
}
