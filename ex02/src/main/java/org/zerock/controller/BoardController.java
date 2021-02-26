package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
   private BoardService service;
   /*@GetMapping("/list")
   public void list(Criteria cri, Model model) {
	   log.info("list:"+cri);
	   model.addAttribute("list",service.getList(cri));
	   model.addAttribute("pageMaker",new PageDTO(cri,123));
   }*/
   
   @GetMapping("/list")
   public void list(Criteria cri,Model model) {
     log.info("list");
      //model.addAttribute("list",service.getList());
       model.addAttribute("list",service.getList(cri));
	   model.addAttribute("pageMaker",new PageDTO(cri,service.getTotal(cri)));
   }
   
   @GetMapping("/register")
   public void register() {
	   
   }
   
   @PostMapping("/register")
   public String register(BoardVO board,RedirectAttributes rttr) {
	   log.info("register:"+board);
	   service.register(board);
	   rttr.addFlashAttribute("result",board.getBno());
	   return "redirect:/board/list";
   }
   
   @GetMapping({"/get","/modify"})
   public void get(@RequestParam("bno")Long bno,@ModelAttribute("cri") Criteria cri,Model model) {
	   log.info("/get or modify");
	   model.addAttribute("board",service.get(bno));
   }
   
   @PostMapping("/modify")
	public String modify(BoardVO board,Criteria cri, RedirectAttributes rttr) {
		
		int count = service.modify(board);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		
		return "redirect:/board/list";
	}
   
   @PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,Criteria cri, RedirectAttributes rttr) {
		
		int count = service.remove(bno);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		
		return "redirect:/board/list";
	}
}
