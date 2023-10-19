package s23.boardgameDatabase.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s23.boardgameDatabase.domain.BoardGame;
import s23.boardgameDatabase.domain.BoardGameRepository;
import s23.boardgameDatabase.domain.CategoryRepository;
import s23.boardgameDatabase.domain.GenreRepository;
import s23.boardgameDatabase.domain.LanguageRepository;

@RestController
public class RestBoardGameController {
	
	@Autowired
	private BoardGameRepository bRepository;
	
	
	@GetMapping("/boardgames")
	public Iterable<BoardGame> getBoardGames() {
		return bRepository.findAll();
	}
	
	
	@GetMapping("/boardgames/{id}")
	public @ResponseBody Optional<BoardGame> findBoardGameRest(@PathVariable("id") Long id) {
		return bRepository.findById(id);
	}
	
	@PostMapping("/boardgames")
	BoardGame newBoardGame(@RequestBody BoardGame newBoardGame) {
		return bRepository.save(newBoardGame);
	}
	
	@PutMapping("/boardgames/{id}")
	BoardGame editBoardGame(@RequestBody BoardGame editedBoardGame, @PathVariable Long id) {
		editedBoardGame.setId(id);
		return bRepository.save(editedBoardGame);
	}
	
	@DeleteMapping("/boardgames/{id}")
	public Iterable<BoardGame> deleteBoardGame(@PathVariable Long id) {
		bRepository.deleteById(id);
		return bRepository.findAll();
	}
}
