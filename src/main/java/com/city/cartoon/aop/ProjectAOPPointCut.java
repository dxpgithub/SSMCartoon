package com.city.cartoon.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//项目切入点集中定义类

@Component
@Aspect
public class ProjectAOPPointCut {
	
	//业务层所有方法切入点
	@Pointcut(value="execution(* com.city.cartoon.service.impl.*.*(..))")
	public void cartoonServiceAllMethodPointCut() {
		
	}

	@Pointcut(value="execution(* com.city.cartoon.service.impl.CartoonServiceImpl.*(..))")
	public void cartoonServiceWithAop() {
		
	}
	
	
	@Pointcut(value="execution(public * *(..))")
	public void AllPublicMethodPointCut() {
		
	}
	
}
