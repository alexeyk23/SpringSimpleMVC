package com.ya.simplemvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ya.simplemvc.model.Primitive;

/**
 * Handles requests for the application home page.
 */
@Controller
@SuppressWarnings("unused")
public class HomeController {
	
	/*private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*List<Primitive> primitives = new ArrayList<Primitive>();
	{
		Primitive p = new Primitive();
		p.setId(1);
		p.setName(2222);
		
		Primitive p2 = new Primitive();
		p2.setId(2);
		p2.setName(3333);
		
		primitives.add(p);
		primitives.add(p2);		
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		//primitives.clear();
		
	/*	model.addAttribute("primitives", primitives);		
		model.addAttribute("prim",new Primitive());
		return "home";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String add(Primitive primitive,BindingResult bindingResult)
	{
		primitives.add(primitive);
		return "redirect:/";
		
	}
	*/
}
