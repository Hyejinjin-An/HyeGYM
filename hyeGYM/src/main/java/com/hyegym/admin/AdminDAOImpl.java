package com.hyegym.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
