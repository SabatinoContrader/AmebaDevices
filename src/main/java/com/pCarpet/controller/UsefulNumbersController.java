package com.pCarpet.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/UsefulNumber")
public class UsefulNumbersController {
	
	@Autowired
	public UsefulNumbersController() {

	}
	
	@RequestMapping(value = "/userNumbers", method = RequestMethod.GET)
	public String getUsefulNumbers(HttpServletRequest request, Model model ) {
		return "usefulNumbers";
	}
}