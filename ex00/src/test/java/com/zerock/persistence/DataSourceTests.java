package com.zerock.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory ssf;
	
	@Test
	public void testConnection() {
		try {
			Connection con = dataSource.getConnection();
			log.info(con);
			SqlSession session = ssf.openSession();
			log.info(session);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
