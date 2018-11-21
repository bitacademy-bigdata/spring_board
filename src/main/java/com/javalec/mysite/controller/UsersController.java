package com.javalec.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.mysite.dao.UsersDAO;
import com.javalec.mysite.vo.UsersVO;

@Controller("users")
public class UsersController {
	@Autowired

	private UsersDAO usersdao ;

	public UsersController() {
		
	
	}

	public void setUsersDAO(UsersDAO usersdao) {
		this.usersdao = usersdao;
	}
	@RequestMapping("/selectUsers.do")
	public UsersVO selectUsers(UsersVO vo){
	  usersdao.selectOne(vo);
		return vo;
	
	}
	
	public void update(UsersVO vo) {
		usersdao.update(vo);
	}
	
	public void insert(UsersVO vo) {
	
		usersdao.insert(vo);
	}
}
