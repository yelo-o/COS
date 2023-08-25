package com.zerock.service;

import java.util.List;

import com.zerock.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();
	public void register(BoardVO board);
	public BoardVO get(long bno);
	public boolean modify(BoardVO board); 
	public boolean remove(long bno); 

}
