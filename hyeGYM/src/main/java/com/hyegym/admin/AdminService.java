package com.hyegym.admin;

import java.util.List;

import com.hyegym.user.ReserveUserDTO;

public interface AdminService{

	public List<AdminDTO> selectUserList() throws Exception;
	public AdminDTO loginCheck(AdminDTO user, jakarta.servlet.http.HttpSession session);
	public List<ReserveUserDTO> selectReserveUserList();
}
