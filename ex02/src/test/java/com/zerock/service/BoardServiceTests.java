package com.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardService service;

	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("서비스 새로운 글 제목 테스트");
		board.setContent("서비스 새로운 글 내용 테스트");
		board.setWriter("서비스 새로운 작성자 테스트");
		service.register(board);
		log.info("새글 번호 : " + board.getBno());
	}
	
	@Test
	public void testGet() {
		log.info(service.get(2L));
	}
	
	@Test
	public void testModify() {
		BoardVO board = service.get(2L);
		if(board == null) {
			return;
		}
		board.setTitle("새로운 제목으로 수정합니다.");
		log.info("수정 성공 여부 : " + service.modify(board));
	}
	
	@Test
	public void testRemove() {
		BoardVO board = service.get(2L);
		if(board == null) {
			return;
		}
		log.info("삭제 성공 여부 : " + service.remove(2L));
	}

}
