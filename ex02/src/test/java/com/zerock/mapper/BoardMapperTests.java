package com.zerock.mapper;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;

	/*
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("대강대강 제목");
		board.setContent("대강대강 내용");
		board.setWriter("대강대강님");
		mapper.insert(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(3L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		int n = mapper.delete(3L);
		log.info(n +" 개의 데이터가 삭제되었습니다.");
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setTitle("제목 수정");
		board.setContent("내용 수정");
		board.setWriter("김민규");
		log.info("Update lines : " + mapper.update(board));
	}
	 */
	@Test
	public void test() {
		Criteria cri = new Criteria(1,10);
		mapper.getListWithPaging(cri).forEach(board -> log.info(board));
		
	}
}
