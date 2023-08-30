package com.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criteria;
import com.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list 요청");
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list : " + cri);
		model.addAttribute("list", service.getList(cri));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register:" + board);
		service.register(board);
		rttr.addFlashAttribute("origin", "register");
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(long bno, Model model) {
		log.info("get : " + bno);
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
		log.info("result : " + board);
	}
	@GetMapping("/modify")
	public void modify(long bno, Model model) {
		log.info("modify : " + bno);
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("moify : " + board);
		boolean result = service.modify(board);
		rttr.addFlashAttribute("origin", "modify");
		if (result) {
			rttr.addFlashAttribute("result", board.getBno());
		} else {
			rttr.addFlashAttribute("result", -1);
		}
		log.info("result : " + result);
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String delete(long bno, RedirectAttributes rttr) {
		log.info("remove : " + bno);
		boolean result = service.remove(bno);
		log.info("result : " + result);
		rttr.addFlashAttribute("origin", "remove");
		if (result) {
			rttr.addFlashAttribute("result", bno);
		} else {
			rttr.addFlashAttribute("result", -1);
		}
		return "redirect:/board/list";
	}
}
