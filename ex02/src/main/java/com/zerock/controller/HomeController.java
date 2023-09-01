package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping("/")
	public String home() {
		log.info("홈페이지 컨트롤러입니다");
		return "redirect:/board/list";
	}
	
}
