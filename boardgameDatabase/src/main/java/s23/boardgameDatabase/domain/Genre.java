package s23.boardgameDatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private Long genreId;
	
	@Size(min=2, max=30)
	@Column(name = "genre_name")
	private String genreName;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<BoardGame> boardGames;

	public Genre(String genreName) {
		this.genreName = genreName;
	}

	public Genre() { }

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<BoardGame> getBoardGames() {
		return boardGames;
	}

	public void setBoardGames(List<BoardGame> boardGames) {
		this.boardGames = boardGames;
	}
	
	

}
