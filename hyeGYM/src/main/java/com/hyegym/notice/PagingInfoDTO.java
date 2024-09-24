package com.hyegym.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingInfoDTO {
	
	/** 페이징 계산에 필요한 파라미터들이 담긴 클래스 */
	private PagingDTO pagingDTO;
	
	/** 전체 데이터 개수 */
	private int totalRecordCount;

	/** 전체 페이지 개수 */
	private int totalPageCount;

	/** 페이지 리스트의 첫 페이지 번호 */
	private int firstPage;

	/** 페이지 리스트의 마지막 페이지 번호 */
	private int lastPage;

	/** SQL의 조건절에 사용되는 마지막 RNUM */
	private int lastRecordIndex;

	/** 이전 페이지 존재 여부 */
	private boolean hasPreviousPage;

	/** 다음 페이지 존재 여부 */
	private boolean hasNextPage;


	public PagingInfoDTO(PagingDTO pagingDTO) {
		if (pagingDTO.getCurrentPageNo() < 1) {
			pagingDTO.setCurrentPageNo(1);
		}
		if (pagingDTO.getContentsPerPage() < 1 || pagingDTO.getContentsPerPage() > 100) {
			pagingDTO.setContentsPerPage(10);
		}
		if (pagingDTO.getPageSize() < 5 || pagingDTO.getPageSize() > 20) {
			pagingDTO.setPageSize(10);
		}

		this.pagingDTO = pagingDTO;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;

		if (totalRecordCount > 0) {
			calculation();
		}
	}

	private void calculation() {
		/* 전체 페이지 수 (현재 페이지 번호가 전체 페이지 수보다 크면 현재 페이지 번호에 전체 페이지 수를 저장) */
		totalPageCount = ((totalRecordCount - 1) / pagingDTO.getContentsPerPage()) + 1;
		if (pagingDTO.getCurrentPageNo() > totalPageCount) {
			pagingDTO.setCurrentPageNo(totalPageCount);
		}

		/* 페이지 리스트의 첫 페이지 번호 */
		firstPage = ((pagingDTO.getCurrentPageNo() - 1) / pagingDTO.getPageSize()) * pagingDTO.getPageSize() + 1;

		/* 페이지 리스트의 마지막 페이지 번호 (마지막 페이지가 전체 페이지 수보다 크면 마지막 페이지에 전체 페이지 수를 저장) */
		lastPage = firstPage + pagingDTO.getPageSize() - 1;
		if (lastPage > totalPageCount) {
			lastPage = totalPageCount;
		}

		/* SQL의 조건절에 사용되는 마지막 RNUM */
		lastRecordIndex = pagingDTO.getCurrentPageNo() * pagingDTO.getContentsPerPage();

		/* 이전 페이지 존재 여부 */
		hasPreviousPage = firstPage != 1;

		/* 다음 페이지 존재 여부 */
		hasNextPage = (lastPage * pagingDTO.getContentsPerPage()) < totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getLastRecordIndex() {
		return lastRecordIndex;
	}

	public void setLastRecordIndex(int lastRecordIndex) {
		this.lastRecordIndex = lastRecordIndex;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

	
	

}
