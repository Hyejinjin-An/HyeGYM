package com.hyegym.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonPagingDTO extends PagingDTO{
	
	/** 페이징 정보 */
	private PagingInfoDTO pagingInfoDTO;
	private PaginationDTO paginationDTO;

	public PaginationDTO getPaginationDTO() {
		return paginationDTO;
	}

	public void setPaginationDTO(PaginationDTO paginationDTO) {
		this.paginationDTO = paginationDTO;
	}

	public PagingInfoDTO getPagingInfoDTO() {
		return pagingInfoDTO;
	}

	public void setPagingInfoDTO(PagingInfoDTO pagingInfoDTO) {
		this.pagingInfoDTO = pagingInfoDTO;
	}


}
