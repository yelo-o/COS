package com.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//@RequestMapping(value = "/", method = RequestMethod.POST)
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println(formattedDate);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //home.jsp 있어야 함
	}
	
	@GetMapping("ex01")
	public String test(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		System.out.println("name : " + name + ",age : " + age);
		logger.info("name : " + name + ",age : " + age);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "ex01";
	}
	
}
