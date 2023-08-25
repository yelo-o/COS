package com.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.domain.BoardVO;
import com.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list 요청");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register:" + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(long bno) {
		log.info("get : " + bno);
		BoardVO board = service.get(bno);
		log.info("result : " + board);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board) {
		log.info("moify : " + board);
		boolean result = service.modify(board);
		log.info("result : " + result);
		return "/board/list";
		
	}
	
	@PostMapping("/delete")
	public String delete(long bno) {
		log.info("delete : " + bno);
		boolean result = service.remove(bno);
		log.info("result : " + result);
		return "/board/list";
	}
}
