package s23.boardgameDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BoardGameRepository extends CrudRepository<BoardGame, Long> {
	
	List<BoardGame> findByTitle(@Param("title") String title);

}
