package com.javalec.mysite.service;

import java.util.List;

import com.javalec.mysite.vo.UsersVO;

public interface IUsersService {
	
	public void insertUsers(UsersVO vo);
	public void updateUsers(UsersVO vo);
	public UsersVO selectUsers(UsersVO vo);
}
