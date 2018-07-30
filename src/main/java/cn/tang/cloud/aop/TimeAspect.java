package cn.tang.cloud.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * 切面类
 * @author wm
 *
 */
@Aspect
@Component
public class TimeAspect {
	
	@Around("execution(* cn.tang.cloud.controller.FastjsonController..*(..))")
	public Object method(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数为:" + arg);
        }

        long start = System.currentTimeMillis();

        Object object = pjp.proceed();//执行controller中业务

        System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));

        return object;
	}
}
