package com.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(LoginException.class)
	public String except(Exception e, Model model) {
		log.error("오류 핸들러 : " + e.getMessage());
		model.addAttribute("exception", e);
		return "login_error_page";
	}

}
