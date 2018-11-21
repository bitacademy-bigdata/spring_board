package com.javalec.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.mysite.dao.BoardDAO;
import com.javalec.mysite.vo.BoardVO;


@Service("boardService")
public class BoardService implements IBoardService {
	@Autowired
	private BoardDAO dao ;
	
	
	@Override
	public void insertboard(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public void deleteboard(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

	@Override
	public List<BoardVO> getboardlist() {
		// TODO Auto-generated method stub
		
		return dao.getboardlist();
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		dao.selectOne(vo);
		return vo;
	}

	@Override
	public void updateboard(BoardVO vo) {
		dao.update(vo);
		
		
	}

}
