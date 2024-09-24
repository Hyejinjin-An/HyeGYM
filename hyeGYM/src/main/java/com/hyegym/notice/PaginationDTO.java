package com.hyegym.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDTO {

	private int listSize = 10; // 초기값으로 목록개수를 10으로 셋팅 (한 페이지당 보여질 리스트 갯수, 컨텐츠)
	private int rangeSize = 10; // 초기값으로 페이지범위를 10으로 셋팅 (한 페이지 범위에 보여질 페이지 갯수, 하단)
	private int page; // 현재 목록의 페이지 번호
	private int range; // 각 페이지 범위 시작 번호
	private int listCnt; // 전체 게시물의 개수
	private int pageCnt; // 전체 페이지 범위의 개수
	private int startPage; // 각 페이지 범위 시작 번호, 하단
	private int endPage; // 각 페이지 범위 끝 번호, 하단
	private int startList;
	private boolean prev; // 이전 페이지 여부
	private boolean next; // 다음 페이지 여부

	
	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;	//현재 페이지 정보
		this.range = range;	//현재 페이지 범위 정보
		this.listCnt = listCnt;	// 전체 게시글 개수
		
		// 전체 페이지수 = 전체 게시글 개수 / 한 페이지당 보여질 게시글 개수 (하단 페이징 버튼 갯수)
		this.pageCnt = (int) Math.ceil((double)listCnt / listSize);
		// 시작 페이지
		this.startPage = (range - 1) * rangeSize + 1;
		// 끝 페이지
		this.endPage = range * rangeSize;
		// 게시판 시작번호 (원하는 목록을 가져오기 위해 필요)
		// 첫번째 게시글의 ROW 값은 0이므로 1페이지 첫 번째~열 번째 게시글은 LIMIT 0, 10
		this.startList = (page - 1) * listSize; 
		// 이전 버튼 상태
		this.prev = range == 1 ? false : true; 
		// 다음 버튼 상태
		// 마지막 페이지가 무조건 10단위로 나오는게 아니라 필요한 범위까지만 나오게 하기 위해
		this.next = endPage > pageCnt ? false : true;
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
	
	public int getRangeSize() {
		return rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getStartList() {
		return startList;
	}

	@Override
	public String toString() {
		return "{ " +
        		"page = " + page + ", " +
                "range = " + range + ", " +
        		"listCnt = " + listCnt + ", " +
                "pageCnt = " + pageCnt + ", " +
                "startPage = " + startPage + ", " +
        		"endPage = " + endPage + " " +
                '}';
	}

}
