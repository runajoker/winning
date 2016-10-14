package net.mds.dev2.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( value = "mvc" )
public class MvcController {
	private static Logger logger = LoggerFactory.getLogger(MvcController.class);
	@RequestMapping(value = "/")
	//value hello와 method hello는 연관없다
	public void root() {
	//   '/hello'가 정석인데 없으면 알아서 붙여준다
		//new ModelAndView("mvc/hello");
	}
	
	@RequestMapping(value = "hello")
	public void hello() {
		//new ModelAndView("mvc/hello");
	}
	@RequestMapping(value = "hello2")
	public void hello2() {
		//new ModelAndView("mvc/hello");
	}
	@RequestMapping("hello3")
	public String hello3() {
		return new String("mvc/hello3");
	}
	@RequestMapping("hello4")
	public void hello4(Model model) {
		model.addAttribute("msg", "Hello @SpringMVC");
	}
	@RequestMapping(
		value = "insert", method = RequestMethod.GET)
	public void insert() {}
	@RequestMapping(
			value = "insert", method = RequestMethod.POST)
	public String insert(String name, String age) {
		logger.info("name : "+name);
		logger.info("name : "+age);
		
		return "mvc/insertPost";
	}
	
}
