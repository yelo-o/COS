package com.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criteria;
import com.zerock.domain.pageDTO;
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
		log.info("list 요청 : " + cri);
		model.addAttribute("list", service.getList(cri));
		//model.addAttribute("pageMaker", new pageDTO(cri, 1000)); //최대개수 계산하기 전에 임의로 넣은 값
		int total = service.getTotal(cri);
		log.info("total : " + total);
		model.addAttribute("pageMaker", new pageDTO(cri, total));
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
	
	
	
//	@GetMapping("/get")
//	public void get(long bno, Criteria cri, Model model) {
//		log.info("get : " + bno);
//		log.info("cri : " + cri);
//		BoardVO board = service.get(bno);
//		model.addAttribute("board", board);
//		log.info("result : " + board);
//	}
//	@GetMapping("/modify")
//	public void modify(long bno, Model model) {
//		log.info("modify : " + bno);
//		BoardVO board = service.get(bno);
//		model.addAttribute("board", board);
//	}
	
	@PostMapping("/modify")
	   public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	      log.info("modify:" + board);
	      log.info("cri:" + cri);
	      boolean result = service.modify(board);
	      log.info("result:" + result);
	      rttr.addFlashAttribute("origin", "modify");
	      if (result)
	         rttr.addFlashAttribute("result", board.getBno());
	      else
	         rttr.addFlashAttribute("result", -1);
	      rttr.addAttribute("pageNum", cri.getPageNum());
	      rttr.addAttribute("amount", cri.getAmount());
	      rttr.addAttribute("type", cri.getType());
	      rttr.addAttribute("keyword", cri.getKeyword());
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
	
	@GetMapping({"/get", "/modify"})
	public void get(long bno, @ModelAttribute("cri") Criteria cri, Model model) {
//		log.info("get:" + bno);
//		log.info("criteria:" + cri);
		BoardVO board =service.get(bno);
		model.addAttribute("board", board);
		log.info("result:" + board);
	}
}
