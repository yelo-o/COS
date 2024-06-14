package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 현재 테스트 코드가 스프링을 실행하는 역할을 할 것을 표시
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 필요한 객체들을 스프링 내 객체로 등록
@Log4j
public class SampleTests {
	
	@Setter(onMethod_ = { @Autowired })
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-------------------------");
		log.info(restaurant.getChef());
		
	}

}
