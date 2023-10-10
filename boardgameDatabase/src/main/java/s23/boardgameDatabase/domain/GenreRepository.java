package s23.boardgameDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	List<Genre> findByGenreName(String genreName);
}
