package s23.boardgameDatabase.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import s23.boardgameDatabase.domain.BoardGame;
import s23.boardgameDatabase.domain.BoardGameRepository;
import s23.boardgameDatabase.domain.CategoryRepository;
import s23.boardgameDatabase.domain.GenreRepository;

@Controller
public class BoardGameController {
	
	
	 @Autowired
	 private BoardGameRepository bRepository;
	 
	 @Autowired
	 private CategoryRepository cRepository;
	 
	 @Autowired
	 private GenreRepository gRepository;
	 
	
	@GetMapping("/index")
	public String showMainPage(Model model) {
		return "index";
	}
	
	@GetMapping("/boardgamelist")
	public String showBoardGameListPage(Model model) {
		model.addAttribute("boardGames", bRepository.findAll());
		
		// Test data
		/*
		List<BoardGame> boardGames = new ArrayList<>();
		
		boardGames.add(new BoardGame("Machi Koro", "demo description", 1, 4, 10));
		boardGames.add(new BoardGame("High Society", "demo description", 3, 5, 14));
		
		// without the max player count
		boardGames.add(new BoardGame("Patchwork - Tilkkutäkki", "testipeli", 2, 8));
		model.addAttribute("boardGames", boardGames); */
		return "boardgamelist";
	}
	
	@GetMapping("/add")
	public String newBoardGame(Model model) {
		model.addAttribute("boardGame", new BoardGame());
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		return "addboardgame";
	}
	
	@PostMapping("/save")
	public String saveNewGame(@Valid @ModelAttribute("boardGame") BoardGame boardGame, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("boardGame", boardGame);
			model.addAttribute("categories", cRepository.findAll());
			model.addAttribute("genres", gRepository.findAll());
			return "addboardgame";
		}
		bRepository.save(boardGame);
		return "redirect:boardgamelist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBoardGame(@PathVariable("id") Long id, Model model) {
		bRepository.deleteById(id);
		return "redirect:../boardgamelist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBoardGame(@PathVariable("id") Long id, Model model) {
		model.addAttribute("boardGame", bRepository.findById(id));
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		
		// add the edit page!
		return "editboardgame";
	}
	
	@GetMapping("/boardgamelist/boardgame/{id}")
	public String showSpecificBoardGamePage(@PathVariable("id") Long id, Model model) {
		Optional<BoardGame> optionalBoardGame = bRepository.findById(id);
		BoardGame boardGame = optionalBoardGame.get();
		model.addAttribute("boardGame", boardGame);
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		return "boardgamedetails";
	}

}
