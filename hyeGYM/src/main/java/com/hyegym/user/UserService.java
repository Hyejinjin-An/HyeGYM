package com.hyegym.user;

import java.util.List;

public interface UserService{

	public List<UserDTO> selectUserList();
	public int insertUser(UserDTO user);
	public UserDTO loginCheck(UserDTO user, jakarta.servlet.http.HttpSession session);
	public int insertReserveUser(ReserveUserDTO user);
	public ReserveUserDTO selectReserveUser(UserDTO user);
	public int deleteReservation(ReserveUserDTO user);
}
