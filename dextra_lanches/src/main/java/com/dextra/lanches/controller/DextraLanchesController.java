package com.dextra.lanches.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DextraLanchesController {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String homepage() { 
		return "index"; 
	}
}
