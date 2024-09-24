package com.hyegym.notice;

import java.util.List;

public interface NoticeService{

	public List<NoticeDTO> selectNoticeList(PaginationDTO pagination);
	public NoticeDTO selectNoticeinfo(int idx);
	public int insertNotice(NoticeDTO contents);
	public int selectContentsTotalCount();
}
