package com.traveler.web.map.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traveler.web.map.service.MyMapService;

@Controller
@RequestMapping("/my")
public class MyMapController {
	@Inject
	private MyMapService mymapService;
	
	@GetMapping("/map")
	public String getMyJournalList(Model model, @RequestParam("author") String author)throws Exception{
		model.addAttribute("myjournalList",mymapService.getMyJournalList(author));
		return "mymap/mymap";
	}
	
	@GetMapping("/list")
	public String getMyJournalTitle(Model model, @RequestParam("journal_no") int journal_no) throws Exception{
		model.addAttribute("title", mymapService.getMyJournalTitle(journal_no));
		model.addAttribute("mydiaryList",mymapService.getMyMapDiary(journal_no));
		return "redirect:/my/map?author=kmg";
	}
	@PostMapping("/list")
    @ResponseBody
    public Map<String, Object> testAjax(int journal_no) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();        
        // 응답 데이터 셋팅
        result.put("title", mymapService.getMyJournalTitle(journal_no));
        result.put("mydiaryList", mymapService.getMyMapDiary(journal_no));
        return result;
        
    }
}
