package com.javalec.mysite.controller;

import java.util.List;

import com.javalec.mysite.dao.BoardDAO;
import com.javalec.mysite.vo.BoardVO;

public class boardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardController controller 
		= new BoardController() ;
		//1. ��Ʈ�ѷ��� dao ��ü ����
		BoardDAO dao = new BoardDAO() ;
		controller.setBoardDAO(dao);
		
		//2. �Է� 
		
		BoardVO vo = new BoardVO() ;
		vo.setTitle("ȫ�浿");
		vo.setWriter("��");
		vo.setContent("�����Դϴ�");
		vo.setId("1");
		controller.insert(vo);
		
		//3. ����Ʈ ��ȸ
		List<BoardVO> getboardlist = controller.getboardlist() ;
		for(BoardVO board : getboardlist) {
			System.out.println(board.toString());
		}
		
	}

}
