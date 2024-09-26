package com.hyegym.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyegym.notice.PaginationDTO;
import com.hyegym.user.ReserveUserDTO;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List<AdminDTO> selectUserList() throws Exception {
		return sqlSessionTemplate.selectList("AdminMapper.userList");
	}

	@Override
	public AdminDTO selectUser(AdminDTO user) {
		return sqlSessionTemplate.selectOne("AdminMapper.selectUser", user);
	}

	@Override
	public List<ReserveUserDTO> selectReserveUserList() {
		return sqlSessionTemplate.selectList("AdminMapper.selectReserveUserList");
	}

	@Override
	public List<AdminDTO> selectLimitUserList(PaginationDTO pagination) {
		return sqlSessionTemplate.selectList("AdminMapper.selectLimitUserList", pagination);
	}

	@Override
	public int selectUserTotalCount() {
		return sqlSessionTemplate.selectOne("AdminMapper.userTotalCount");
	}

	@Override
	public int selectReserveTotalCount() {
		return sqlSessionTemplate.selectOne("AdminMapper.reserveTotalCount");
	}

	@Override
	public List<ReserveUserDTO> selectLimitReserveUserList(PaginationDTO pagination) {
		return sqlSessionTemplate.selectList("AdminMapper.selectLimitReserveUserList", pagination);
	}

}
