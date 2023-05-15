package com.mes.jss;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/index")
	public String hom() {
		
		return "layout/index";
	}

	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/top")
	public String top() {
		
		return "top";
	}
	

	@GetMapping("/user/user")
	public String user(/* @AuthenticationPrincipal Principal uservo, */ HttpSession session) {
		
		String sessionLoginId = (String) session.getAttribute("loingId");
		System.out.println(sessionLoginId);
		
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		System.out.println(userDetails.getUsername());
		
//		System.out.println(uservo.getName());		// userId
		return "user/user";
	}
	
	@GetMapping("/admin/admin")
	public void admin() {  }
	
}
