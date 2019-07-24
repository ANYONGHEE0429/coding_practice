package com.test.web.util;

import lombok.Data;

@Data
public class PageNavigator {
	
	private int countPerPage;		//페이지당 글목록 수
	private int pagePerGroup;		//그룹당 페이지 수 
	private int currentPage;		//현재 페이지 (최근 글이 1부터 시작)
	private int totalRecordsCount;	//전체 글 수
	private int totalPageCount;		//전체 페이지 수
	private int currentGroup;		//현재 그룹 (최근 그룹이 0부터 시작)
	private int startPageGroup;		//현재 그룹의 첫 페이지
	private int endPageGroup;		//현재 그룹의 마지막 페이지
	private int startRecord;		//전체 레코드 중 현재 페이지 첫 글의 위치 (0부터 시작)
	
	/*
	 * 생성자
	 */
	public PageNavigator(int countPerPage, int pagePerGroup, int currentPage, int totalRecordsCount) {
		//페이지당 글 수, 그룹당 페이지 수, 현재 페이지, 전체 글 수를 전달받음
		this.countPerPage = countPerPage; //한 페이지에 몇개의 글을 출력할건지
		this.pagePerGroup = pagePerGroup; //하단 페이지의 수를 몇개 출력할건지
		//currentPage 내가 보고싶은 페이지 출력
		this.totalRecordsCount = totalRecordsCount;	//데이터베이스에 저장된 글 전체 출력
		
		//전체 페이지 수
		totalPageCount = (totalRecordsCount + countPerPage - 1) / countPerPage;

		//전달된 현재 페이지가 1보다 작으면 현재페이지를 1페이지로 지정
		if (currentPage < 1)	currentPage = 1;	//1보다 작은 페이지는 존재하지 않는다!
		//전달된 현재 페이지가 마지막 페이지보다 크면 현재페이지를 마지막 페이지로 지정
		if (currentPage > totalPageCount)	currentPage = totalPageCount;	//반대로도 존재하지 않는다.
		
		this.currentPage = currentPage;

		//현재 그룹
		currentGroup = (currentPage - 1) / pagePerGroup;
		
		//현재 그룹의 첫 페이지
		startPageGroup = currentGroup * pagePerGroup + 1;
		//현재 그룹의 마지막 페이지
		endPageGroup = startPageGroup + pagePerGroup - 1;
		//현재 그룹의 마지막 페이지가 전체 페이지 수보다 크면 마지막 페이지를 전체 페이지 수로 지정
		endPageGroup = endPageGroup > totalPageCount ? totalPageCount : endPageGroup;

		//전체 레코드 중 현재 페이지 첫 글의 위치(RowBounds 전달용)
		startRecord = (currentPage - 1) * countPerPage;
	}
}
