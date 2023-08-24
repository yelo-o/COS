package com.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String name;
	private int age;
	//@DateTimeFormat(pattern = "yyyy/MM/dd")
//	private Date date;
}
