package s23.boardgameDatabase.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardgameController {
	
	@GetMapping("/index")
	public String showMainPage(Model model) {
		return "index";
	}

}
