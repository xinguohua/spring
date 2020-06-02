package eee.tju.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
//@Aspect
public class LogUtils {


    //@Before("execution(public int tju.impl.Calculatorimpl.*(int, int))")
    public static void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法开始执行"+"参数是"+Arrays.asList(joinPoint.getArgs()));
    }

    //@AfterReturning(value = "execution(public  int tju.impl.Calculatorimpl.*(int,int))",returning = "result")
    public static void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"方法正常执行完成："+"结果"+result);
    }

    //@AfterThrowing(value = "execution(public  int tju.impl.Calculatorimpl.*(int,int))",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e) {
        System.out.println(joinPoint.getSignature().getName()+"方法执行出现异常了"+e);
    }

    //@After("execution(public  int tju.impl.Calculatorimpl.*(int,int))")
    public static void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+"方法最终结束了");}

    //@Around("execution(public int eee.tju.impl.Calculatorimpl.*(int, int))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable{

        Object[] args = pjp.getArgs();
        String name = pjp.getSignature().getName();
        Object proceed = null;
        try {
            //@Before
            System.out.println("【环绕前置通知】【"+name+"方法开始】");
            //就是利用反射调用目标方法即可，就是method.invoke(obj,args)
            proceed = pjp.proceed(args);
            //@AfterReturing
            System.out.println("【环绕返回通知】【"+name+"方法返回，返回值"+proceed+"】");
        } catch (Exception e) {
            //@AfterThrowing
            System.out.println("【环绕异常通知】【"+name+"】方法出现异常，异常信息："+e);
            //为了让外界能知道这个异常，这个异常一定抛出去
            throw new RuntimeException(e);
        } finally{
            //@After
            System.out.println("【环绕后置通知】【"+name+"】方法结束");
        }

        //反射调用后的返回值也一定返回出去
        return proceed;
    }
}


 