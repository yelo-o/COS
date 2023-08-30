package com.zerock.mapper;

import java.util.List;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criteria;

public interface BoardMapper {
	//@Select("select * from tbl_board")
	//public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	public BoardVO read(long bno);
	public int delete(long bno);
	public int update(BoardVO board);
}
