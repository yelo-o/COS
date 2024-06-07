package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
//	@Setter(onMethod = @__({ @Autowired }))
	@Setter(onMethod_ = @Autowired) // 위와 같으나 더 최신의 방법
	private Chef chef;

}
