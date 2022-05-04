package com.example.exercise13_1.advice;

import com.example.exercise13_1.jms.EmailSenderServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;


import java.util.Date;


public class EmailAdvice {

    public void emailLogger(JoinPoint joinPoint){
        Object[] args= joinPoint.getArgs();
        System.out.println(new Date()+" method="+joinPoint.getSignature().getName());
        String address=(String) args[0];
        String message=(String) args[1];

        EmailSenderServiceImpl objects= (EmailSenderServiceImpl) joinPoint.getTarget();

        System.out.println("address="+address+"\n"+"message="+message);
        System.out.println("outgoing mail server ="+objects.getOutgoingMailServer());
    }

    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute "+call.getSignature().getName()+"="+totalTime);
// print the time to the console
        return retVal; }


}
