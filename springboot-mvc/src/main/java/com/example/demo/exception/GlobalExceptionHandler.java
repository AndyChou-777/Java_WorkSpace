package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.response.ApiResponse;

// 利用 @ControllerAdvice 的特性來處理「全局」錯誤
@ControllerAdvice
public class GlobalExceptionHandler {
	
	// 當系統發生 Exception 或 HttpStatus.BAD_REQUEST 時的處理方法
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ApiResponse<Object>> handleException(NumberFormatException e){
		ApiResponse<Object> apiresponse = ApiResponse.error(HttpStatus.BAD_REQUEST.value(), "無效的數據格式, " + e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiresponse);
	}
	
	//
	// 當系統發生 Exception 或 HttpStatus.INTERNAL_SERVER_ERROR 時的處理方法
		@ExceptionHandler(Exception.class)
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		public ResponseEntity<ApiResponse<Object>> handleNumberFormatException(NumberFormatException e){
			ApiResponse<Object> apiresponse = ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "伺服器內部錯誤, " + e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiresponse);
		}

}
