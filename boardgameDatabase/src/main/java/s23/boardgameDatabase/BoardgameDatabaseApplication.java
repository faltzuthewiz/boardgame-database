package s23.boardgameDatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.boardgameDatabase.domain.BoardGame;
import s23.boardgameDatabase.domain.BoardGameRepository;
import s23.boardgameDatabase.domain.Category;
import s23.boardgameDatabase.domain.CategoryRepository;
import s23.boardgameDatabase.domain.Genre;
import s23.boardgameDatabase.domain.GenreRepository;
import s23.boardgameDatabase.domain.Language;
import s23.boardgameDatabase.domain.LanguageRepository;

@SpringBootApplication
public class BoardgameDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardgameDatabaseApplication.class, args);
	}
	
	
	  @Bean public CommandLineRunner demoData(BoardGameRepository bRepository, CategoryRepository cRepository, GenreRepository gRepository, LanguageRepository lRepository) {
	  return (args) -> { 
		  cRepository.save(new Category("Board game"));
		  cRepository.save(new Category("Card game"));
		  
		  gRepository.save(new Genre("City Building"));
		  gRepository.save(new Genre("Family"));
		  
		  lRepository.save(new Language("English"));
		  lRepository.save(new Language("Finnish"));
		  
		  
		  bRepository.save(new BoardGame("Machi Koro", "demo description", 1, 4, 10, 30, cRepository.findByCategoryName("Card game").get(0), gRepository.findByGenreName("City Building").get(0), lRepository.findByLanguageName("English").get(0))); 
		  bRepository.save(new BoardGame("High Society", "demo description", 3, 5, 14, 20, cRepository.findByCategoryName("Card game").get(0), gRepository.findByGenreName("Family").get(0), lRepository.findByLanguageName("English").get(0)));
			
		  // without the max player count
		 // bRepository.save(new BoardGame("Patchwork - Tilkkutäkki", "testipeli", 2, 8));
		  }; 
	  }
	 

}
