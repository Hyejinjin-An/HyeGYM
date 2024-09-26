package com.hyegym.user;

import java.util.List;

public interface UserDAO {

	public List<UserDTO> selectUserList();
	public int insertUser(UserDTO user);
	public UserDTO selectUser(UserDTO user);
	public int insertReserveUser(ReserveUserDTO user);
	public ReserveUserDTO selectReserveUser(UserDTO user);
	public int deleteReservation(ReserveUserDTO user);
}
