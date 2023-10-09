package s23.boardgameDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BoardGameRepository extends CrudRepository<BoardGame, Long> {
	
	List<BoardGame> findByTitle(String title);

}
