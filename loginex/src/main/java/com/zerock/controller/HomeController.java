package com.zerock.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zerock.domain.MemberDTO;
import com.zerock.exception.LoginException;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home() {
		logger.info("Welcome home! This is login page.");
		
		return "home";
	}
	/* 아이디와 비밀번호가 맞지 않을 때 직접 error_page로 보내기
	@GetMapping("/success")
	public String success(MemberDTO member) {
		log.info(member.getId());
		log.info(member.getPassword());
		
		if(member.getId().equals("admin") && member.getPassword().equals("pwd")) {
			return "success";
		}
		return "error_page";
	}
	*/
	
	@GetMapping("/success")
	public String loginSuccess(MemberDTO member, Model model) throws LoginException {
		log.info(member.getId());
		log.info(member.getPassword());
		model.addAttribute("id", member.getId());
		model.addAttribute("password", member.getPassword());
		if(member.getId().equals("admin") && member.getPassword().equals("pwd")) {
			return "success";
		} else {
			throw new LoginException("아이디와 비밀번호가 다릅니다. " + 
					"입력한 ID : " + member.getId() +
					", 입력한 비밀번호 : " + member.getPassword());
		}
	}
}
