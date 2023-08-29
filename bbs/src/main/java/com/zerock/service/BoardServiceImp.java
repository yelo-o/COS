package com.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.domain.BoardVO;
import com.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImp implements BoardService {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		log.info("getList() service is called");
		return mapper.getList();
	}

	@Override
	public void register(BoardVO board) {
		log.info("register() service is called by board : " + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(long bno) {
		log.info("get() service is called by bno : " + bno );
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify() service is called by board : " + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(long bno) {
		log.info("remove() service is called by bno : " + bno);
		return mapper.delete(bno) == 1;
	}

}
