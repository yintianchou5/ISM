package org.dzq.ssm.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	@Before("execution(* org.dzq.ssm.service.impl.AdminServiceImpl.*(..))")
	public void before() {
		System.out.println("前置通知");
	}
}
