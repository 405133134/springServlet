package cn.enn.springServlet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class TestController {
	private Logger log = Logger.getLogger(TestController.class);
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value="/count")
	public String count(Model model){
		int i=testService.count();
		log.info(i);
		model.addAttribute("count", i);
		return "user";
	}
	
}
