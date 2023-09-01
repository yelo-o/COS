package com.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class pageDTO {
	
	private int startPage;
	private int endPage;
	private int total;
	private boolean prev, next;
	private Criteria cri;
	
	public pageDTO() {
		
	}
	
	public pageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

}
