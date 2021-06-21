package com.traveler.web.journal.controller;

import java.io.Console;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMethod;

import com.traveler.web.diary.model.DiaryVO;
import com.traveler.web.diary.service.DiaryService;
import com.traveler.web.journal.model.JournalVO;
import com.traveler.web.journal.service.JournalService;
import com.traveler.web.user.controller.UserController;

@Controller
@RequestMapping("/journal")
public class JournalController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private JournalService journalService;
	
	@Inject
	private DiaryService diaryService;
	
	@GetMapping("/list")
	public String getJournalList(Model model, @RequestParam("id") String author) throws Exception{
		List<JournalVO> journalList = journalService.getJournalList(author);
		List<List<DiaryVO>> diaryList = new ArrayList<>();
		model.addAttribute("journalList", journalList);
		for(int i=0; i<journalList.size(); i++) {
			diaryList.add(diaryService.getList(journalList.get(i).getJournal_no()));
		}if(diaryList != null) {
			model.addAttribute("diarylist", diaryList);
		}
		return "journal/journalList";
	}
	
	@GetMapping("/create")
	public String createJournal(@ModelAttribute("journalVO") JournalVO journalVO, Model model) throws Exception{
		return "journal/createJournal";
	}
	
	@GetMapping("/update")
	public String updateJournal(@RequestParam("journal_no") int journal_no, @RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("journalContent", journalService.getJournalContent(journal_no));
		model.addAttribute("mode", mode);
		model.addAttribute("journalVO", new JournalVO());
		return "journal/updateJournal";
	}
	
	@GetMapping("/delete")
	public String deleteBoard(RedirectAttributes rttr, @RequestParam("journal_no") int journal_no) throws Exception {
		journalService.deleteJournal(journal_no);
		return "redirect:/journal/list";
	}
	
	@PostMapping("/saveJournal")
	public String saveJouarnal(@ModelAttribute("JournalVO") JournalVO journalVO,  @RequestParam("id") String author, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception {
		if (mode.equals("edit")) {
			journalService.updateJournal(journalVO);
		} else {
			journalService.insertJournal(journalVO);
		}
		return "redirect:/journal/list?id="+author;
	}
	
	@PostMapping("/journalSearch")
		public String searchList(@RequestParam("search_title") String search_title, @RequestParam("search_date") String search_date, @RequestParam("search_author") String search_author, Model model) throws Exception {
		String path = null;
		List<JournalVO> journalList = new ArrayList<>();
		List<List<DiaryVO>> diaryList = new ArrayList<>();
		for(int i=0; i<journalList.size(); i++) {
			diaryList.add(diaryService.getList(journalList.get(i).getJournal_no()));
		}if(diaryList != null) {
			model.addAttribute("diarylist", diaryList);
		}
		if (search_date.equals("") && search_author.equals("")) {//title로 검색할때
				journalList = journalService.searchListTitle(search_title);
				model.addAttribute("journalList", journalList);
			} else if (search_title == "" && search_author == "" ) {
				journalList = journalService.searchListDate(search_date);
				model.addAttribute("journalList", journalList);
			} else 	if (search_date == "" && search_title == "" ) {
				journalList = journalService.searchListAuthor(search_author);
				model.addAttribute("journalList", journalList);
			}
		for(int i=0; i<journalList.size(); i++) {
			diaryList.add(diaryService.getList(journalList.get(i).getJournal_no()));
		}if(diaryList != null) {
			model.addAttribute("diarylist", diaryList);
		}
		return "journal/journalSearch";
			//return contextRoot+"journal/journalList";//절대경로 값 찾는것.
		}
}
