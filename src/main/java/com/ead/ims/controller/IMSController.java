package com.ead.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ead.ims.model.Product;

@Controller
public class IMSController {
	
	@RequestMapping(value="/homepage")
	public String homepage()
	{
		return "homepage.html";
	}
}
