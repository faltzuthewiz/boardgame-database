package s23.boardgameDatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long languageId;
	
	@NotNull
	@Size(min=2, max=30)
	private String languageName;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
	private List<BoardGame> boardGames;
	
	

	public Language(@NotNull @Size(min = 2, max = 30) String languageName) {
		this.languageName = languageName;
	}
	
	public Language() { } 

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	public List<BoardGame> getBoardGames() {
		return boardGames;
	}

	public void setBoardGames(List<BoardGame> boardGames) {
		this.boardGames = boardGames;
	}

}
