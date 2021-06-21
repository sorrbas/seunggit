package com.traveler.web.diary.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;
import com.traveler.web.diary.model.DiaryVO;
import com.traveler.web.diary.model.ReplyVO;
import com.traveler.web.diary.service.DiaryService;
import com.traveler.web.diary.service.ReplyService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
@RequestMapping("/diary/*")
public class DiaryController {
	

	private final DiaryService service;
	
	@Inject
	ReplyService replyService;
	
	@GetMapping("diarylist")
	public void list(Model model, @RequestParam("journal_no") int journal_no) {
		model.addAttribute("diarylist", service.getList(journal_no));
	}
	
	@GetMapping("write")
	public void write() { //등록 작업은 post방식으로 처리하지만, 화면에서 입력을 받아야 하므로 get방식으로 페이지를 볼수 있도록 해야함.
		
	}
	
	@PostMapping("write")
	public String write(DiaryVO diary, RedirectAttributes rtr, HttpServletRequest request) {
		int journal_no = Integer.parseInt(request.getParameter("journal_no"));
		diary.setJournal_no(journal_no);
		String imgchoose = diary.getDiary();	//본문 데이터 가져오기.
		String imglocs="{\"imglocs\":[";		//json 형식의 String으로 이미지파일의 경로값만을 담기위한 변수 선언.
		while(imgchoose.indexOf("src=\"")!=-1) {	// src=" 을 포함하는 경우에 계속 반복. 더이상 src=" 을 포함하지 않을 경우 종료.
			imgchoose=imgchoose.substring(imgchoose.indexOf("src=\"")+5,imgchoose.length());	//본문의 맨처음 문자부터 src=" 이라는 문자열 까지 버림.
			String imgloc = imgchoose.substring(0,62);		// 필요로 하는 경로값은 항상 62글자이므로 첫글자부터 62번 글자까지가 경로값이다.
			if(imgloc.charAt(imgloc.length()-1)=='e') {		// 다만 한가지 예외가 확장자가 jpeg였을 경우인데 이 경우 jpe까지만 서브스트링으로 들어간다.
				imgloc+="g";								// 마지막 글자가 e인 경우 확장자가 잘린 경우이니 g를 다시 붙혀준다.
			}
			imglocs += "{\"imgloc\":\"";					// json 형식 추가
			imglocs +=imgloc;								// 경로값 저장
			imglocs += "\"},";								// json 형식 추가
			imgchoose=imgchoose.substring(62, imgchoose.length());		// 이미 사용한 경로값을 버린 다음 while문을 반복한다.
		}
		imglocs=imglocs.substring(0, imglocs.length()-2);	// 마지막 , 제거
		imglocs+="}]}";										// json 포맷 마무리
		diary.setImglocs(imglocs);							// json 포맷의 String으로 완성된 imglocs를 diaryVO에 넣어준다.
		service.write(diary);								// db로 전달.
		rtr.addFlashAttribute("result", diary.getDiary_no());
		
		return "redirect:/diary/diarylist?journal_no="+journal_no;					// 목록 페이지로 이동.
	}
	
	@GetMapping({"info", "update"})
	public void info(@RequestParam("diary_no") int diary_no, Model model) { //requestParam을 이용해서 tno 값을 좀 더 명시적으로 처리. 
		
		model.addAttribute("diary", service.info(diary_no)); //해당 번호의 게시물을 전달해야 하므로 model을 파라미터로 지정한다.
	
		List<ReplyVO> replyList = replyService.viewReply(diary_no);
		model.addAttribute("replyList",replyList);
			
	}
	
	@PostMapping("update")
	public String update(DiaryVO diary, RedirectAttributes rtr) {
		
		String imgchoose = diary.getDiary();	//본문 데이터 가져오기.
		String imglocs="{\"imglocs\":[";		//json 형식의 String으로 이미지파일의 경로값만을 담기위한 변수 선언.
		while(imgchoose.indexOf("src=\"")!=-1) {	// src=" 을 포함하는 경우에 계속 반복. 더이상 src=" 을 포함하지 않을 경우 종료.
			imgchoose=imgchoose.substring(imgchoose.indexOf("src=\"")+5,imgchoose.length());	//본문의 맨처음 문자부터 src=" 이라는 문자열 까지 버림.
			String imgloc = imgchoose.substring(0,62);		// 필요로 하는 경로값은 항상 62글자이므로 첫글자부터 62번 글자까지가 경로값이다.
			if(imgloc.charAt(imgloc.length()-1)=='e') {		// 다만 한가지 예외가 확장자가 jpeg였을 경우인데 이 경우 jpe까지만 서브스트링으로 들어간다.
				imgloc+="g";								// 마지막 글자가 e인 경우 확장자가 잘린 경우이니 g를 다시 붙혀준다.
			}
			imglocs += "{\"imgloc\":\"";					// json 형식 추가
			imglocs +=imgloc;								// 경로값 저장
			imglocs += "\"},";								// json 형식 추가
			imgchoose=imgchoose.substring(62, imgchoose.length());		// 이미 사용한 경로값을 버린 다음 while문을 반복한다.
		}
		imglocs=imglocs.substring(0, imglocs.length()-2);	// 마지막 , 제거
		imglocs+="}]}";										// json 포맷 마무리
		diary.setImglocs(imglocs);							// json 포맷의 String으로 완성된 imglocs를 diaryVO에 넣어준다.
		
		int count = service.update(diary);
		
		if(count == 1) {
			rtr.addFlashAttribute("result", "success");
		}
		return "redirect:/diary/diarylist?journal_no="+diary.getJournal_no();
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("diary_no") int diary_no,@RequestParam("journal_no") int journal_no, RedirectAttributes rtr) {
		
		int count = service.delete(diary_no);
		
		if(count == 1) {
			rtr.addFlashAttribute("result", "delSuccess");
		}
		return "redirect:/diary/diarylist?journal_no="+journal_no;
	}
	
	@RequestMapping(value="/uploadFile", produces = "application/json; charset=utf8")
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request )  {
		JsonObject jsonObject = new JsonObject();
		
        /*
		 * String fileRoot = "C:\\summernote_image\\"; // 외부경로로 저장을 희망할때.
		 */
		
		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot = contextRoot+"resources/fileupload/";
		
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/resources/fileupload/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a;
	}
	
	//댓글작성
	@GetMapping("replyWrite")
	public String replyWrite(ReplyVO vo, RedirectAttributes rttr, @RequestParam("journal_no") int journal_no) {
		
		replyService.writeReply(vo);
		
		rttr.addAttribute("diary_no",vo.getDiary_no());
		
		return "redirect:/diary/info?journal_no="+journal_no;
		
	}
	
	//댓글 수정
	@GetMapping("replyUpdateView")
	public String replyUpdateView(ReplyVO vo, Model model) {
		
		model.addAttribute("replyUpdate", replyService.selectReply(vo.getReply()));
		
		return "diary/replyUpdateView";
		
	}
	
	@PostMapping("replyUpdate")
	public String replyUpdate(ReplyVO vo, RedirectAttributes rttr, @RequestParam("journal_no") int journal_no) {
		replyService.updateReply(vo);
		
		rttr.addAttribute("diary_no", vo.getDiary_no());
		
		return "redirect:/diary/info?journal_no="+journal_no;
		
	}
	
	//댓글 삭제
	@PostMapping("/replyDeleteView")
	@ResponseBody
	public Map<String, Object> replyDeleteView(int reply, int diary_no) {
		ReplyVO vo =new ReplyVO();
		vo.setReply(reply);
		Map<String, Object> result = new HashMap<String, Object>();        
        // 응답 데이터 셋팅
		replyService.deleteReply(vo);
		List<ReplyVO> replyList = replyService.viewReply(diary_no);
        result.put("replyList", replyList);
//        model.addAttribute("replyList",replyList);
        return result;
		
	}
	
	@RequestMapping(value="replyDelete", method= {RequestMethod.GET, RequestMethod.POST})
	public String replyDele(ReplyVO vo, RedirectAttributes rttr, @RequestParam("journal_no") int journal_no) {
		
		replyService.deleteReply(vo);
	
		rttr.addAttribute("diary_no",vo.getDiary_no());
		
		return "redirect:/diary/info?journal_no="+journal_no;
		
	}

}
