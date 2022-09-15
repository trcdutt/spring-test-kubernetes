package com.trc.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValController {
	@RequestMapping(value= "/vals", method = RequestMethod.POST)
	@ResponseBody
	public String postSessionValues(@RequestBody String name, HttpSession session) {
//		ModelAndView mv = new ModelAndView("home");
		ArrayList<String> vals = (ArrayList<String>) session.getAttribute("sessionvalues");
		if (vals == null) {
			vals = new ArrayList<>();
			name = name + " created at : " + new Date();			
		}
		else {
			name = name + " created at : " + new Date();	
		}
		vals.add(name);		
		session.setAttribute("sessionvalues", vals);
		vals = (ArrayList<String>) session.getAttribute("sessionvalues");
		StringBuilder sb = new StringBuilder();
		sb.append("<ol>");
		for (String str : vals) {
			sb.append("<li>").append(str).append("</li>");
		}
		sb.append("</ol>");
		return  sb.toString();	
				
	}
}
