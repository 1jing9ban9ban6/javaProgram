package com.jing.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jing
 * @create 2020-03-06-22:46
 */
@Component
@Aspect//表住当前类为切面
@Order(value = 2)
public class myLog {
    /**
     * 用来讲方法指定为前置通知 必须设置value 为切入点表达式
     */
//    @Before(value = "execution(public int com.jing.spring.aop.math.add(int, int))")
//    @Before(value = "execution(public int com.jing.spring.aop.math.*(int, int))")
//    @Before(value = "execution(* com.jing.spring.aop.math.*(int, int))")
    @Before(value = "execution(* com.jing.spring.aop.*.*(..))")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();//获取方法参数
        String name = joinPoint.getSignature().getName();//获取方法名字
        System.out.println("方法执行之前"+name);
    }

    /**
     * 后置通知应该放在异常里 finally 不管有没有异常都要执行
//     * @param joinPoint
     * @return
     */
    @After(value = "execution(* com.jing.spring.aop.*.*(..))")
    public static void after(JoinPoint joinPoint){
        System.out.println("我是后置通知");
    }
    // 返回通知可以接收返回值 作用于方法执行之后
    @AfterReturning(value = "execution(* com.jing.spring.aop.*.*(..))", returning="result")
    public void afterReturn(JoinPoint joinPoint, Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+" "+result);
        // 有异常就不执行了
    }
    @AfterThrowing(value = "execution(* com.jing.spring.aop.*.*(..))", throwing = "ex")
    public void throwing(Exception ex){
        System.out.println("有异常了"+ex);
        ex.printStackTrace();
    }
//    @Around(value = "execution(* com.jing.spring.aop.*.*(..))")
//    public Object around(ProceedingJoinPoint point){
//        Object proceed = null;
//        try {
//            //前置
//            System.out.println("前置");
//            proceed = point.proceed();//代表执行方法 相当于invoke
//            //返回
//            System.out.println("返回"+proceed);
//            return proceed;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            //异常
//            System.out.println("异常");
//        }finally {
//            //后置
//            System.out.println("后置");
//        }
//        return -1;
//    }
}
