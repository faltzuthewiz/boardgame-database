package s23.boardgameDatabase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import s23.boardgameDatabase.domain.BoardGame;
import s23.boardgameDatabase.domain.BoardGameRepository;
import s23.boardgameDatabase.domain.CategoryRepository;
import s23.boardgameDatabase.domain.GenreRepository;
import s23.boardgameDatabase.domain.LanguageRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BoardGameRepositoryTest {
	
	@Autowired
	BoardGameRepository bRepository;
	
	@Autowired
	CategoryRepository cRepository;
	
	@Autowired
	GenreRepository gRepository;
	
	@Autowired
	LanguageRepository lRepository;

	@Test
	public void findAllBoardGamesShouldReturnFiveRows() {
		Iterable<BoardGame> boardGames = bRepository.findAll();
		assertThat(boardGames).hasSize(5);
	}

	@Test
	public void checkTheNameOfTheFirstBoardGameReturned() {
		List<BoardGame> boardGames = (List<BoardGame>) bRepository.findAll();
		assertThat(boardGames.get(0).getTitle()).isEqualTo("Machi Koro - 5th anniversary edition");
	}
	
	@Test
	public void createNewBoardGame() {
		BoardGame newBoardGame = new BoardGame("Lux Aeterna", "Mayday! Mayday! --- This is the test description and I don't want to save this to my original database", 1, 0, 10, 15, cRepository.findByCategoryName("Card game").get(0), gRepository.findByGenreName("Hand management").get(0), lRepository.findByLanguageName("English").get(0));
		
		bRepository.save(newBoardGame);
		assertThat(newBoardGame.getId()).isNotNull();
	}
	
	@Test
	public void deleteSecondBoardGame() {
		List<BoardGame> boardGames = (List<BoardGame>) bRepository.findAll();
		
		bRepository.deleteById(boardGames.get(1).getId());
		
		assertThat(boardGames).hasSize(5);
		List<BoardGame> secondBook = bRepository.findByTitle("#Koulutusleikkaus");
		
		assertThat(secondBook).hasSize(0);
	}
}
