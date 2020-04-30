package com.jing.ioc.math;

import jdk.nashorn.internal.codegen.ObjectClassGenerator;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jing
 * @create 2020-03-06-21:25
 */
public class proxyUtil {

    public static Object getProxy(Object o){
        ClassLoader loader = o.getClass().getClassLoader();
        Class<?>[] classes = o.getClass().getInterfaces();
        myInvoke invoke = new myInvoke(o);
        return Proxy.newProxyInstance(loader, classes, invoke);
    }
}
class myInvoke implements InvocationHandler{
    private Object object;
    public myInvoke(Object o){
        this.object=o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前");
        Object invoke = method.invoke(object, args);
        System.out.println("后");
        return invoke;
    }
}

