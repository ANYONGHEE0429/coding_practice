package com.test.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.web.service.GuestbookService;
import com.test.web.vo.GuestbookVO;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService service;
	
	// 방명록 리스트 화면 이동
	@RequestMapping(value = "guestbookList", method = {RequestMethod.GET, RequestMethod.POST})
	public String guestbookList(Model model) {
		System.out.println("GuestbookList 메서드 호출");
		ArrayList<GuestbookVO> list = service.guestbookList();
		model.addAttribute("list", list);
		return "/guestbook/guestbookList";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(GuestbookVO vo, Model model, MultipartFile uploadFile) {
		boolean result = service.write(vo,uploadFile);
		model.addAttribute("writeResult", result);
		return "forward:/guestbook/guestbookList";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(GuestbookVO vo, Model model, RedirectAttributes attr) {
		boolean result = service.delete(vo);
		model.addAttribute("deleteResult", result);
		return "forward:/guestbook/guestbookList";
	}
	
	@RequestMapping(value= "download",method = RequestMethod.GET)
	public void download(int seq,HttpServletResponse response){	
		GuestbookVO vo = service.read(seq);
		service.download(vo, response);
	}
	
}
