package com.javalec.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.mysite.dao.UsersDAO;
import com.javalec.mysite.vo.UsersVO;
@Service("usersService")
public class UsersService implements IUsersService {

	@Autowired
	private UsersDAO dao ;
	
	@Override
	public void insertUsers(UsersVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void updateUsers(UsersVO vo) {
		dao.update(vo);
	}

	@Override
	public UsersVO selectUsers(UsersVO vo) {
		dao.selectOne(vo);
		return vo;
	}

}
