package s23.boardgameDatabase.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import s23.boardgameDatabase.domain.BoardGame;
import s23.boardgameDatabase.domain.BoardGameRepository;

@Controller
public class BoardGameController {
	
	/*
	 * @Autowired private BoardGameRepository bRepository;
	 */
	
	@GetMapping("/index")
	public String showMainPage(Model model) {
		return "index";
	}
	
	@GetMapping("/boardgamelist")
	public String showBoardGameListPage(Model model) {
	//	model.addAttribute("boardGames", bRepository.findAll());
		
		// Test data
		List<BoardGame> boardGames = new ArrayList<>();
		
		boardGames.add(new BoardGame("Machi Koro", "demo description", 1, 4, 10));
		boardGames.add(new BoardGame("High Society", "demo description", 3, 5, 14));
		
		// without the max player count
		boardGames.add(new BoardGame("Patchwork - Tilkkutäkki", "testipeli", 2, 8));
		model.addAttribute("boardGames", boardGames);
		return "boardgamelist";
	}

}
