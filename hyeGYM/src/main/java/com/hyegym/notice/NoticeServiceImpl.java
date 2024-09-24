package com.hyegym.notice;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	private Logger log = LogManager.getLogger();

	@Override
	public List<NoticeDTO> selectNoticeList(PaginationDTO pagination) {
		return noticeDAO.selectNoticeList(pagination);
	}

	@Override
	public NoticeDTO selectNoticeinfo(int idx) {
		NoticeDTO list = noticeDAO.selectNoticeinfo(idx);
		return list;
	}
	
	@Override
	public int insertNotice(NoticeDTO contents) {;
		return noticeDAO.insertNotice(contents);
	}

	@Override
	public int selectContentsTotalCount() {
		return noticeDAO.selectContentsTotalCount();
	}

}