package com.hyegym.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;

	
	@Override
	public List<UserDTO> selectUserList() {
		return sqlSessionTemplate.selectList("UserMapper.userList");
	}

	@Override
	public int insertUser(UserDTO user) {
		return sqlSessionTemplate.insert("UserMapper.insertUser", user);
	}

	@Override
	public UserDTO selectUser(UserDTO user) {
		return sqlSessionTemplate.selectOne("UserMapper.selectUser", user);
	}

	@Override
	public int insertReserveUser(ReserveUserDTO user) {
		return sqlSessionTemplate.insert("UserMapper.insertReserveUser", user);
	}

	@Override
	public ReserveUserDTO selectReserveUser(UserDTO user) {
		return sqlSessionTemplate.selectOne("UserMapper.selectReserveUser", user);
	}

	@Override
	public int deleteReservation(ReserveUserDTO user) {
		return sqlSessionTemplate.delete("UserMapper.deleteReservation", user);
	}

}
