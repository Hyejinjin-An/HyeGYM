package com.hyegym.admin;

import java.util.List;

import com.hyegym.notice.PaginationDTO;
import com.hyegym.user.ReserveUserDTO;

public interface AdminService{

	public List<AdminDTO> selectUserList() throws Exception;
	public AdminDTO loginCheck(AdminDTO user, jakarta.servlet.http.HttpSession session);
	public List<ReserveUserDTO> selectReserveUserList();
	public List<AdminDTO> selectLimitUserList(PaginationDTO pagination);
	public int selectUserTotalCount();
	public int selectReserveTotalCount();
	public List<ReserveUserDTO> selectLimitReserveUserList(PaginationDTO pagination);
}
