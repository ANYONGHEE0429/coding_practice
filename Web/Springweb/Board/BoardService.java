package com.test.web.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.test.web.dao.BoardDAO;
import com.test.web.util.PageNavigator;
import com.test.web.vo.BoardVO;
import com.test.web.vo.ReplyVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;

	private final int countPerPage = 10;
	private final int pagePerGroup = 5;

	public ArrayList<BoardVO> boardList(String searchItem, String searchKeyword, PageNavigator navi) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchKeyword", searchKeyword);
		return dao.boardList(map, navi.getStartRecord(), navi.getCountPerPage());
	}

	public BoardVO boardRead(int boardNum) {
		return dao.boardRead(boardNum);
	}

	public boolean boardDelete(BoardVO vo, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		vo.setUserid(userid);
		
		String savedFilename = dao.boardRead(vo.getBoardNum()).getSavedFilename();//첨부파일 삭제

		if (dao.boardDelete(vo) != 1) return false;
		File file = new File("C:/text/" + savedFilename);// 첨부파일 삭제
		if (file.exists()) file.delete(); //첨부파일 삭제
		return true;
	}

	public boolean boardUpadte(BoardVO vo, HttpSession session, MultipartFile uploadFile) {
		System.out.println("service"+uploadFile);
		String oldSavedFilename = vo.getSavedFilename();
		String userid = (String) session.getAttribute("userid");
		vo.setUserid(userid);
		
		// 수정 내용에 첨부파일이 등록되어 있을 경우		
		if(!uploadFile.isEmpty()){
		//VO 객체에 새로운 첨부 파일명을 set
			vo.setOriginalFilename(uploadFile.getOriginalFilename());
		//VO객체에 새롭게 서버에 저장될 파일명을 set
			vo.setSavedFilename(UUID.randomUUID().toString());
			
			File file = new File("C:/text/" + vo.getSavedFilename());
			
			try {
				//새로운 첨부파일을 서버에 저장
				uploadFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Update query 가 실패할 경우
			if(dao.boardUpdate(vo) != 1){
				//서버에 저장했던 새로운 첨부파일을 삭제
				file.delete();
				return false;
			}
			
			//Update query 가 성공했을 경우
			File oldFile = new File("C:/text/" + oldSavedFilename);
			//수정전 게시글에 첨부파일이 존재할 경우 삭제
			if(oldFile.exists()) oldFile.delete();
			return true;
		}
		

		//수정 내용에 첨부파일이 없을 경우
		if(dao.boardUpdate(vo) != 1) return false;
		return true;
		
	}

	public boolean boardWrite(BoardVO vo, HttpSession session, MultipartFile uploadFile) {
		if (!uploadFile.isEmpty()) {
			String originalFilename = uploadFile.getOriginalFilename();
			String savedFilename = UUID.randomUUID().toString();

			vo.setOriginalFilename(originalFilename);;
			vo.setSavedFilename(savedFilename);

			try {
				uploadFile.transferTo(new File("C:/text/" + savedFilename));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String userid = (String) session.getAttribute("userid");
		vo.setUserid(userid);
		if (dao.boardWrite(vo) != 1)
			return false;
		return true;
	}

	public void replyWrite(ReplyVO vo, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		vo.setUserid(userid);
		dao.replyWrite(vo);
	}

	public ArrayList<ReplyVO> replyList(int boardNum) {
		return dao.replyList(boardNum);
	}

	public void replyUpdate(ReplyVO vo, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		vo.setUserid(userid);
		dao.replyUpdate(vo);
	}

	public void replyDelete(ReplyVO vo, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		vo.setUserid(userid);
		dao.replyDelete(vo);
	}

	public PageNavigator getNavi(int currentPage, String searchItem, String searchKeyword) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchKeyword", searchKeyword);
		map.put("searchItem", searchItem);
		int totalRecordsCount = dao.getTotal(map);
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordsCount);
		return navi;
	}

	public void boardDownload(BoardVO vo, HttpServletResponse response) {
		File file = new File("C:/text/" + vo.getSavedFilename());
		String originalFilename = vo.getOriginalFilename();

		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(originalFilename, "UTF-8"));
			response.setContentLength((int) file.length());
			FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
