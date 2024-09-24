package com.hyegym.admin;

import java.util.List;

import com.hyegym.user.ReserveUserDTO;

public interface AdminDAO {

	public List<AdminDTO> selectUserList() throws Exception;
	public AdminDTO selectUser(AdminDTO user);
	public List<ReserveUserDTO> selectReserveUserList();
}
