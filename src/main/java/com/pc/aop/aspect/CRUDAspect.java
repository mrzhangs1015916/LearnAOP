package com.pc.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * CRUD的(Aspect)切面类
 * Created by switch on 16/10/1.
 */
// 注解为Aspect(切面)类
@Aspect
@Component("crudAspect")
public class CRUDAspect {

    // Advise(通知)注解，参数为CutPoint(切入点)
    // 通过AOP保证所有所有的Service接口在正常调用返回后以及抛出异常时（Service接口模拟），打出如下信息：函数名称，函数参数，并说明发生的事件：正常返回或者抛出异常。
    @AfterThrowing("execution(* com.pc.aop.service.*.*(..))")
    public void crudDoLogInThrowing(JoinPoint jp) {
        // 打印函数名称
        String methodName = jp.getSignature().toString();
        // 截取签名中的函数名部分
        methodName = methodName.substring(methodName.lastIndexOf('.') + 1, methodName.indexOf('('));
        System.out.println("函数名为：" + methodName);
        // 打印函数所有参数
        for (int i = 0; i < jp.getArgs().length; i++) {
            System.out.println("第" + (i + 1) + "个参数为：" + jp.getArgs()[i]);
        }
        System.out.println("抛出异常");
    }
    @Before("execution(* com.pc.aop.service.UserService.select(..))")
    public void ShowZsName(){
        System.out.println("张帅");
    }
    @Around("execution(* com.pc.aop.service.UserService.insert(..))")
    public void AroundFunc(ProceedingJoinPoint jp){
        System.out.println("开始...");
        try {
            jp.proceed();
            System.out.println("结束...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @AfterReturning("execution(* com.pc.aop.service.*.*(..))")
    public void crudDoLogInReturning(JoinPoint jp) {
        // 打印函数名称
        String methodName = jp.getSignature().toString();
        // 截取签名中的函数名部分
        methodName = methodName.substring(methodName.lastIndexOf('.') + 1, methodName.indexOf('('));
        System.out.println("函数名为：" + methodName);
        // 打印函数所有参数
        for (int i = 0; i < jp.getArgs().length; i++) {
            System.out.println("第" + (i + 1) + "个参数为：" + jp.getArgs()[i]);
        }
        System.out.println("正常返回");
    }

}
