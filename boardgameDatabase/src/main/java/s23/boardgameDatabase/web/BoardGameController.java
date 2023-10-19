package s23.boardgameDatabase.web;

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
import s23.boardgameDatabase.domain.LanguageRepository;

@Controller
public class BoardGameController {
	
	
	 @Autowired
	 private BoardGameRepository bRepository;
	 
	 @Autowired
	 private CategoryRepository cRepository;
	 
	 @Autowired
	 private GenreRepository gRepository;
	 
	 @Autowired
	 private LanguageRepository lRepository;
	 
	
	@GetMapping("/index")
	public String showMainPage(Model model) {
		return "index";
	}
	
	@GetMapping("/boardgamelist")
	public String showBoardGameListPage(Model model) {
		model.addAttribute("boardGames", bRepository.findAll());
		
		return "boardgamelist";
	}
	
	@GetMapping("/add")
	public String newBoardGame(Model model) {
		model.addAttribute("boardGame", new BoardGame());
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		model.addAttribute("languages", lRepository.findAll());
		return "addboardgame";
	}
	
	@PostMapping("/savenew")
	public String saveNewGame(@Valid @ModelAttribute("boardGame") BoardGame newBoardGame, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("boardGame", newBoardGame);
			model.addAttribute("categories", cRepository.findAll());
			model.addAttribute("genres", gRepository.findAll());
			model.addAttribute("languages", lRepository.findAll());
			return "addboardgame";
		}
		bRepository.save(newBoardGame);
		return "redirect:boardgamelist";
	}
	
	@PostMapping("/save-edited")
	public String saveEditedGame(@Valid @ModelAttribute("boardGame") BoardGame editedBoardGame, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("boardGame", editedBoardGame);
			model.addAttribute("categories", cRepository.findAll());
			model.addAttribute("genres", gRepository.findAll());
			model.addAttribute("languages", lRepository.findAll());
			return "editboardgame";
		}
		bRepository.save(editedBoardGame);
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
		model.addAttribute("languages", lRepository.findAll());
		
		return "editboardgame";
	}
	
	@GetMapping("/boardgamelist/boardgame/{id}")
	public String showSpecificBoardGamePage(@PathVariable("id") Long id, Model model) {
		Optional<BoardGame> optionalBoardGame = bRepository.findById(id);
		BoardGame boardGame = optionalBoardGame.get();
		model.addAttribute("boardGame", boardGame);
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		model.addAttribute("languages", lRepository.findAll());
		return "boardgamedetails";
	}

}
