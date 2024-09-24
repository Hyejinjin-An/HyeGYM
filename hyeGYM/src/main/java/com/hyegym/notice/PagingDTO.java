package com.hyegym.notice;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingDTO {
	
	private int currentPageNo;		// 현재 페이지
	private int contentsPerPage;	// 페이지 당 출력할 데이터 갯수
	private int pageSize;			// 하단에 출력할 페이지 사이즈
	
	
	public PagingDTO() {
		this.currentPageNo = 1;
		this.contentsPerPage = 10;
		this.pageSize = 10;
	}
	
	public int getStartPage() {
		return (currentPageNo - 1) * contentsPerPage;
	}
	
	public String makeQueryString(int pageNo) {
		/*
		 * Criteria 클래스의 멤버 변수들을 쿼리 스트링(Query String) 형태로 반환한다.
		 * 스프링에서 제공하는 UriComponents 클래스를 사용하면 URI를 더욱 더 효율적으로 처리할 수 있다.
		 */
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("currentPageNo", pageNo)
				.queryParam("recordsPerPage", contentsPerPage)
				.queryParam("pageSize", pageSize)
				.build()
				.encode();

		return uriComponents.toUriString();
	}
	
    @Override
    public String toString() {
        return "PagingDTO info : {" +
        		"currentPageNo = " + currentPageNo + ", " +
                "recordsPerPage = " + contentsPerPage + ", " +
        		"pageSize = " + pageSize + '}';
    }

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getContentsPerPage() {
		return contentsPerPage;
	}

	public void setContentsPerPage(int contentsPerPage) {
		this.contentsPerPage = contentsPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
