package s23.boardgameDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	List<Language> findByLanguageName(String languageName);

}
