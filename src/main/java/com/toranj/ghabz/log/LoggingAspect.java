package com.toranj.ghabz.log;

import com.toranj.ghabz.dao.LoggingTableDAO;
import com.toranj.ghabz.entity.LoggingTable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoggingTableDAO loggingTableDAO;

    /**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Pointcut that matches all Spring beans in the application's controller packages.
     */
    @Pointcut("execution(* com.toranj.ghabz.controller.*.*(..)))")
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Pointcut("@annotation(com.toranj.ghabz.log.Log)")
    public void methodsWithLogAnnotation() {

    }

    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

            System.out.println("Log After Throwing Exception!!!!!!");
            log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
            LoggingTable loggingTable = new LoggingTable();
            loggingTable.setId(UUID.randomUUID().toString());
            loggingTable.setErrorMessage("Error: " + joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName() + "()");
            loggingTable.setCreationDate(new Date());
            loggingTableDAO.save(loggingTable);


    }

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("applicationPackagePointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            LoggingTable loggingTable = new LoggingTable();
            loggingTable.setId(UUID.randomUUID().toString());
            loggingTable.setCreationDate(new Date());
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String details = auth.getDetails().toString();
            loggingTable.setUserIp(details.substring(details.indexOf("RemoteIpAddress")+17,details.indexOf("SessionId")-2));
            String debugMessage = null;
            String errorMessage = null;

            if(auth != null){
               loggingTable.setUserName(auth.getName());
            }

            if (log.isDebugEnabled()) {
                log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
                debugMessage = "Enter: " + joinPoint.getSignature().getDeclaringTypeName() + "."
                        + joinPoint.getSignature().getName() + "()";
                if(debugMessage.length()>100){
                    debugMessage = debugMessage.substring(0,99);
                }
                loggingTable.setDebugMessage(debugMessage);

            }

            try {
                Object result = joinPoint.proceed();
                if(result.equals("error")){
                    errorMessage = "Error: " + joinPoint.getSignature().getDeclaringTypeName() + "."
                            + joinPoint.getSignature().getName() + "()";
                    if (errorMessage.length()>100){
                        errorMessage = errorMessage.substring(0,99);
                    }
                    loggingTable.setErrorMessage(errorMessage);
                }
                else {
                    if (log.isDebugEnabled()) {
                        log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                                joinPoint.getSignature().getName(), result);
                    }
                }

                Object[] arguments = joinPoint.getArgs();
                String methodArgument = null;
                for (Object argument : arguments) {
                    if(argument instanceof String){
                        methodArgument += argument + " ";
                    }
                }
                loggingTable.setMethodArgument(methodArgument);
                loggingTableDAO.save(loggingTable);

                return result;
            } catch (IllegalArgumentException e1) {
                errorMessage = "Error: " + joinPoint.getSignature().getDeclaringTypeName() + "."
                        + joinPoint.getSignature().getName() + "()";
                if (errorMessage.length()>100){
                    errorMessage = errorMessage.substring(0,99);
                }
                loggingTable.setErrorMessage(errorMessage);
                loggingTableDAO.save(loggingTable);
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }



}

