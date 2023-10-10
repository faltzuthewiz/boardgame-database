package s23.boardgameDatabase.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class BoardGame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String description;
	
	private long minPlayer;
	private long maxPlayer;
	private long minAge;
	
	// Also category , genre, language
	
	public BoardGame() {}

	public BoardGame(String title, String description, long minPlayer, long maxPlayer, long minAge) {
		this.title = title;
		this.description = description;
		this.minPlayer = minPlayer;
		this.maxPlayer = maxPlayer;
		this.minAge = minAge;
	}

	public BoardGame(String title, String description, long minPlayer, long minAge) {
		super();
		this.title = title;
		this.description = description;
		this.minPlayer = minPlayer;
		this.minAge = minAge;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMinPlayer() {
		return minPlayer;
	}

	public void setMinPlayer(long minPlayer) {
		this.minPlayer = minPlayer;
	}

	public long getMaxPlayer() {
		return maxPlayer;
	}

	public void setMaxPlayer(long maxPlayer) {
		this.maxPlayer = maxPlayer;
	}

	public long getMinAge() {
		return minAge;
	}

	public void setMinAge(long minAge) {
		this.minAge = minAge;
	}
	
}
