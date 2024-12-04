package com.example.cart.aop;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.cart.model.dto.OrderItemDTO;

// 針對結帳進行 log 紀錄
// OrderService.saveOrder
// 隨堂練習
@Aspect
@Component
public class LogAspect {

	// 建立 Logger 實例
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	// 定義切點
	@Pointcut("execution(* com.example.cart.service.OrderService.*(..))")
	public void saveOrder() {}
	
	// Order log 紀錄 + 檢核參數
	// 前置通知
	@Before(value = "saveOrder() && args(userId, items)")
	public void before(Long userId, List<OrderItemDTO> items) {
		System.out.println("OrderServiceAspect: 前置通知");
		logger.info("userId={}, items={}", userId, items);
		if(userId == null || items == null) {
			throw new IllegalArgumentException("結帳出錯");
		}
	}
	
	// 取得 Order + log 記錄
	// 返回通知
	@AfterReturning(value = "pt()", returning = "result")
	public void afterReturning(Object result) {
		System.out.println("OrderServiceAspect: 返回通知");
		logger.info("Order={}", result);
	}
	
	// 方法在執行時本身就發生例外 + log 紀錄
	// 例外通知
	@AfterThrowing(value = "pt()", throwing = "ex")
	public void afterThrowing(Exception ex) {
		logger.info("ex={}", ex);
	}
		
}
