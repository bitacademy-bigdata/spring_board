package com.javalec.mysite.controller;

import java.util.List;

import com.javalec.mysite.dao.BoardDAO;
import com.javalec.mysite.vo.BoardVO;

public class boardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardController controller 
		= new BoardController() ;
		//1. 컨트롤러에 dao 객체 세팅
		BoardDAO dao = new BoardDAO() ;
		controller.setBoardDAO(dao);
		
		//2. 입력 
		
		BoardVO vo = new BoardVO() ;
		vo.setTitle("홍길동");
		vo.setWriter("김");
		vo.setContent("내용입니다");
		vo.setId("1");
		controller.insert(vo);
		
		//3. 리스트 조회
		List<BoardVO> getboardlist = controller.getboardlist() ;
		for(BoardVO board : getboardlist) {
			System.out.println(board.toString());
		}
		
	}

}
