package com.JMS.Diamond.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/principal")
public class principalView {
	
	
	@GetMapping
	public String interfas() {
		return "principal";
	}


}
