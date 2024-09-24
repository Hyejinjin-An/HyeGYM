package com.hyegym.notice;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface NoticeDAO {

	public List<NoticeDTO> selectNoticeList(PaginationDTO pagination);
	public NoticeDTO selectNoticeinfo(int idx);
	public int insertNotice(NoticeDTO contents);
	public int selectContentsTotalCount();
}
