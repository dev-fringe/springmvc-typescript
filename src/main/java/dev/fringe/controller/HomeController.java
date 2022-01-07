package dev.fringe.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homeInit(Locale locale, Model model) {
		return "index";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public Object test() {
		Map map = new HashMap<>();
		map.put("sds", "sdsd");
		return map;
	}
}
