package s23.boardgameDatabase.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s23.boardgameDatabase.domain.BoardGame;
import s23.boardgameDatabase.domain.BoardGameRepository;

@RestController
public class RestBoardGameController {
	
	@Autowired
	private BoardGameRepository bRepository;
	
	@GetMapping("/boardgame/{id}")
	public @ResponseBody Optional<BoardGame> findBoardGameRest(@PathVariable("id") Long id) {
		return bRepository.findById(id);
	}

}
