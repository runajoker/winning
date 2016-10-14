package net.mds.dev2.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="restful")
public class RestfulController {

	/*@RequestMapping(value="{name}") name에 따라 다른 jsp 가게 된다.
	public void iAm(@PathVariable String name, Model model) {
		model.addAttribute("", "그래 난" + name);
	}*/
	
	@RequestMapping(value="/want/{want}")
	public String want(Model model, @PathVariable String want) {
		model.addAttribute("iam", "<font color=\"pink\">안선생님</font>" + want);
		return "restful/iam";
	}
	@RequestMapping(value="jung")
	public String iam(Model model) {
		model.addAttribute("iam", "그래 난 jung1211"  );
		return "restful/iam";
	}
	@RequestMapping(value="{age}/{name}")
	public String want(Model model, @PathVariable int age, @PathVariable String name) {
		model.addAttribute("iam", "<font color=\"pink\">안녕하새오</font><img src=\"../../resources/img/15.gif\">" + age + "살이고오 이름은 " + name + "애오");
		return "restful/iam";
	}
	
}
