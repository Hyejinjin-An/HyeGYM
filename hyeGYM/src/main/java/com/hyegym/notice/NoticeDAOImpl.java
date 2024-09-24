package com.hyegym.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO{

	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;

	
	@Override
	public List<NoticeDTO> selectNoticeList(PaginationDTO pagination) {
		return sqlSessionTemplate.selectList("NoticeMapper.noticeListLimit", pagination);
	}


	@Override
	public NoticeDTO selectNoticeinfo(int num) {
		return sqlSessionTemplate.selectOne("NoticeMapper.noticeInfo", num);
	}
	
	@Override
	public int insertNotice(NoticeDTO contents) {
		return sqlSessionTemplate.insert("NoticeMapper.insertNotice", contents);
	}

	@Override
	public int selectContentsTotalCount() {
		return sqlSessionTemplate.selectOne("NoticeMapper.noticeTotalCount");
	}

}
