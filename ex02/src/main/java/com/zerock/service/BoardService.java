package com.zerock.service;

import java.util.List;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criteria;

public interface BoardService {

	//public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	
	public void register(BoardVO board);
	public BoardVO get(long bno);
	public boolean modify(BoardVO board); 
	public boolean remove(long bno); 

}
