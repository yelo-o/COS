package com.zerock.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zerock.domain.SampleDTO;
import com.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample") //localhost:8888/controller/sample
@Log4j
public class SampleController {
	//private static final Logger logger = LoggerFactory.getLogger(SampleController.class); 
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, false));
		
	}
	
	@GetMapping("/ex03") //localhost:8888/controller/sample/ex03
	public String ex03(TodoDTO todo, @ModelAttribute("p") int page) {
		log.info("DTO 확인 : "+ todo);
		log.info("page 확인 : "+ page);
		return "/sample/ex03";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06 실행");
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(40);
		return dto;
	}

}
