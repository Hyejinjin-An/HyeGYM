package com.hyegym.admin;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyegym.user.ReserveUserDTO;

@Service
public class AdminServiceImpl implements AdminService{

	private Logger log = LogManager.getLogger();
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<AdminDTO> selectUserList() throws Exception{
		return adminDAO.selectUserList();
	}
	
	@Override
	public AdminDTO loginCheck(AdminDTO user, jakarta.servlet.http.HttpSession session) {
		AdminDTO res = adminDAO.selectUser(user);
		if (res != null && res.getId() != null) {
			log.info("로그인 조회 완료 . . .");
			session.setAttribute("userinfo", res);
		}else {
			log.debug("로그인 조회 실패 . . .");
		}
		return res;
	}

	@Override
	public List<ReserveUserDTO> selectReserveUserList() {
		return adminDAO.selectReserveUserList();
	}

}
