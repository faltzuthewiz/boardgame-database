package s23.boardgameDatabase;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s23.boardgameDatabase.web.BoardGameController;

@SpringBootTest
class BoardgameDatabaseApplicationTests {
	
	@Autowired
	private BoardGameController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
