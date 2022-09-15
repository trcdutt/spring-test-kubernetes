package com.trc.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

	@RequestMapping("/")
	public ModelAndView sayHello(HttpSession session, Model model) {
		System.out.println("Reached here- 1");
		ModelAndView mv = new ModelAndView("home");
		ArrayList<String> vals = (ArrayList<String>) session.getAttribute("sessionvalues");
//		mv.addObject("sessionvalues" , vals);
		System.out.println("Reached here with vals " + vals == null ? "null" : vals);
		vals = (ArrayList<String>) session.getAttribute("sessionvalues");
		StringBuilder sb = new StringBuilder();
		sb.append("<ol>");
		if (vals != null) {
		for (String str : vals) {
			sb.append("<li>").append(str).append("</li>");
		}
		sb.append("</ol>");	
		}
		model.addAttribute("sessionvalues" , vals);
		
		return  mv;
	}
	

	@GetMapping("/check")
	public String getValues() {

		return "Check working";
	}
	
}
