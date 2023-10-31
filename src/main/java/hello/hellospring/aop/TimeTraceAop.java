package hello.hellospring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect// aop는 aspect어노테이션을 추가해야한다
@Component // spring bean 등록 또는 springConfig에 @bean 어노테이션으로 등록한다
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")//hello.hellospring 하위 패키지에 다 적용한다.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());

        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+ joinPoint.toString() + " "+ timeMs + "ms");
        }
    }
}
