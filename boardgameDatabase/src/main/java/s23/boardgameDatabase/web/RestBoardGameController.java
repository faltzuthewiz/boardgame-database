package s23.boardgameDatabase.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

@RestController
public class RestBoardGameController {
	
	@Autowired
	private BoardGameRepository bRepository;
	
	
	@GetMapping("/boardgames")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public Iterable<BoardGame> getBoardGames() {
		return bRepository.findAll();
	}
	
	
	@GetMapping("/boardgames/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public @ResponseBody Optional<BoardGame> findBoardGameRest(@PathVariable("id") Long id) {
		return bRepository.findById(id);
	}
	
	@PostMapping("/boardgames")
	@PreAuthorize("hasAuthority('ADMIN'")
	BoardGame newBoardGame(@RequestBody BoardGame newBoardGame) {
		return bRepository.save(newBoardGame);
	}
	
	@PutMapping("/boardgames/{id}")
	@PreAuthorize("hasAuthority('ADMIN'")
	BoardGame editBoardGame(@RequestBody BoardGame editedBoardGame, @PathVariable Long id) {
		editedBoardGame.setId(id);
		return bRepository.save(editedBoardGame);
	}
	
	@DeleteMapping("/boardgames/{id}")
	@PreAuthorize("hasAuthority('ADMIN'")
	public Iterable<BoardGame> deleteBoardGame(@PathVariable Long id) {
		bRepository.deleteById(id);
		return bRepository.findAll();
	}
}
