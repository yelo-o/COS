package com.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT * FROM users")
	public String getTime();
	
	public String getTime2();

}
