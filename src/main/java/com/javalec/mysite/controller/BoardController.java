package com.javalec.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.javalec.mysite.vo.BoardVO;
import com.javalec.mysite.dao.BoardDAO;

@Controller("borad")
public class BoardController {
	
	@Autowired

	private BoardDAO boarddao ;

	public BoardController() {
		
	
	}

	public void setBoardDAO(BoardDAO boarddao) {
		this.boarddao = boarddao;
	}

	public List<BoardVO> getboardlist(){
		List<BoardVO> list = boarddao.getboardlist();
		return list;
	
	}
	
	public void delete(BoardVO vo) {
		boarddao.delete(vo);
	}
	
	public void insert(BoardVO vo) {
	
		boarddao.insert(vo);
	}

	
}