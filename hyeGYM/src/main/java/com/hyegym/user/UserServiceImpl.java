package com.hyegym.user;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	private Logger log = LogManager.getLogger();

	@Override
	public List<UserDTO> selectUserList() {
		return userDAO.selectUserList();
	}

	@Override
	public int insertUser(UserDTO user) {
		int res = userDAO.insertUser(user);
		return res;
	}

	@Override
	public UserDTO loginCheck(UserDTO user, jakarta.servlet.http.HttpSession session) {
		UserDTO res = userDAO.selectUser(user);
		if (res != null && res.getId() != null) {
			log.info("로그인 조회 완료 . . .");
			session.setAttribute("userinfo", res);
		}else {
			log.debug("로그인 조회 실패 . . .");
		}
		return res;
	}

	@Override
	public int insertReserveUser(ReserveUserDTO user) {
		return userDAO.insertReserveUser(user);
	}

	@Override
	public ReserveUserDTO selectReserveUser(UserDTO user) {
		return userDAO.selectReserveUser(user);
	}

	@Override
	public int deleteReservation(ReserveUserDTO user) {
		return userDAO.deleteReservation(user);
	}
	
	
}
