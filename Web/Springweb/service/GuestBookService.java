package com.test.web.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.test.web.dao.GuestbookDAO;
import com.test.web.vo.GuestbookVO;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDAO dao;
	
	public boolean write(GuestbookVO vo, MultipartFile uploadFile) {
		if(!uploadFile.isEmpty()){//사용자가 첨부파일을 보냈냐 안보냈냐(선택사항)
			String originalFilename = uploadFile.getOriginalFilename();
			String savedFilename = UUID.randomUUID().toString();
				
			vo.setOriginalFilename(originalFilename);
			vo.setSavedFilename(savedFilename);
			
			try {
				uploadFile.transferTo(new File("C:/test/"+savedFilename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
			
		if(dao.write(vo) != 1) return false;
		return true;
	}
	
	// 방명록 리스트
	public ArrayList<GuestbookVO> guestbookList() {
		return dao.guestbookList();
	}
	
	
	public boolean delete(GuestbookVO vo) {
		/*Guestbook guestbookVO = dao.read(vo.getSeq());*/
		String savedFilename = dao.read(vo.getSeq()).getSavedFilename();
		File file =new File("C:/text/" + savedFilename);
		if(dao.delete(vo) != 1) return false;
		if(file.exists()) file.delete();
		return true;
	}

	public GuestbookVO read(int seq) {
		return dao.read(seq);
		
	}

	public void download(GuestbookVO vo, HttpServletResponse response) {
		File file = new File("C:/text/"+ vo.getSavedFilename()); //다운로드를 받을 준비
		String originalFilename = vo.getOriginalFilename(); //위와 동일
		
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(originalFilename, "UTF-8"));
			//response는 응답을 하고 Header는 응답에 대한 정보를 갖고 있고 셋헤더를 불름 Content-Disposition이응답에 대한 종류를 지정(담고있음),
			//attachment는 다운로드파일을 의미 , filename은 다운로드 받았을때 다운로드 받은 파일의 이름
			response.setContentLength((int)file.length());
			//응답한 파일의 크기 지정은 setContentLength=다운로드 받은 파일의 크기 지정
			FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
			//클라언트 컴퓨터에 다운로드 받게끔 지정
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public GuestbookVO boardRead(int boardNum) {
		// TODO Auto-generated method stub
		return null;
	}
}
