package s23.boardgameDatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.boardgameDatabase.domain.BoardGame;
import s23.boardgameDatabase.domain.BoardGameRepository;

@SpringBootApplication
public class BoardgameDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardgameDatabaseApplication.class, args);
	}
	
	/*
	 * @Bean public CommandLineRunner demoData(BoardGameRepository bRepository) {
	 * return (args) -> { bRepository.save(new BoardGame("Machi Koro",
	 * "demo description", 1, 4, 10)); }; }
	 */

}
