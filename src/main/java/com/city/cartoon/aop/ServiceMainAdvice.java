package com.city.cartoon.aop;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.city.cartoon.model.CartoonModel;





//业务层Advice
@Component("serviceMainAdvice")
@Aspect
public class ServiceMainAdvice {
	
	 @Before("com.city.cartoon.aop.ProjectAOPPointCut.cartoonServiceAllMethodPointCut()")
	    public void before(JoinPoint joinPoint) throws Throwable {
	      System.out.println("==================前置执行=====================>");
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        System.out.println("请求来源： =》" + request.getRemoteAddr());
	        System.out.println("请求URL：" + request.getRequestURL().toString());
	        System.out.println("请求方式：" + request.getMethod());
	        System.out.println("响应方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	       
	        System.out.println("==================前置执行完成==================>");
	        
	       
	    }

	 @After("com.city.cartoon.aop.ProjectAOPPointCut.cartoonServiceAllMethodPointCut()")
	    public void after(JoinPoint joinPoint) throws Throwable {
	       System.out.println("==================后置执行=====================>");
	       String methodName = joinPoint.getTarget().getClass().getName();
	       System.out.println("执行方法为"+methodName);
	       
	        System.out.println("==================后置执行完成==================>");
	        
	       
	    }

	
	/*
	 * 方法类环绕切面,切入类方法记录类的运行时间
	 */
	@Around(value="com.city.cartoon.aop.ProjectAOPPointCut.cartoonServiceAllMethodPointCut()")
	public Object serviceMethodRunTime(ProceedingJoinPoint pjp) throws Throwable{
		
		Date start=new Date();
		
		Object result=pjp.proceed();
		
		Date end=new Date();
		System.out.println("环绕切面执行：类："+pjp.getTarget().getClass().getName()+"方法："+pjp.getSignature().getName()+"执行时间是："+(end.getTime()-start.getTime())+"毫秒");
		return result;
	}
	
	
	/*
	 * 异常后切面，记录类方法抛出异常的时间
	 */
	@SuppressWarnings("deprecation")
	@AfterThrowing(value="com.city.cartoon.aop.ProjectAOPPointCut.cartoonServiceAllMethodPointCut()",throwing="ex")
	public void exceptionHanding(JoinPoint jp,Exception ex) throws Exception{
		Date throwsdate=new Date();
		System.out.println("异常抛出后执行：类: "+jp.getTarget().getClass().getName()+" 方法："+jp.getSignature().getName()
				+" 时间: "+throwsdate.getYear()+"年"+throwsdate.getMonth()+"月"+throwsdate.getDay()+"日"+throwsdate.getHours()+"时"+throwsdate.getMinutes()+"分"+throwsdate.getSeconds()+"秒"+
				"异常："+ex.getMessage());
	}
	
	
	
	//方法返回后Advice方法
	@SuppressWarnings("rawtypes")
	@AfterReturning(value="com.city.cartoon.aop.ProjectAOPPointCut.cartoonServiceAllMethodPointCut()", returning="result")
	public void methodAfterReturing(Object result) throws Exception{
		System.out.println("业务层方法返回后切面代码执行。。。。");
		if(result instanceof List<?>) {
			System.out.println("返回集合个数："+((List)result).size());
		}
		else if(result instanceof CartoonModel) {
			System.out.println("返回漫画名称："+ ((CartoonModel)result).getCartoonname());
		}
	}
	
	
	
	
	
}
