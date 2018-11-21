package com.javalec.mysite.service;

import java.util.List;


import com.javalec.mysite.vo.BoardVO;

public interface IBoardService {
	
	public void insertboard(BoardVO vo);
	public void deleteboard(BoardVO vo);
	public List<BoardVO> getboardlist();
	public BoardVO selectOne(BoardVO vo);
	public void updateboard(BoardVO vo);
}
