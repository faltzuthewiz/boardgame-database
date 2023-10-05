package s23.boardgameDatabase.domain;

public class BoardGame {
	
	private Long id;
	private String title;
	private String description;
	
	private Long minPlayer;
	private Long maxPlayer;
	private Long minAge;
	private Long maxAge;
	
	// Also category , genre, language
	
	public BoardGame() {}

	public BoardGame(Long id, String title, String description, Long minPlayer, Long maxPlayer, Long minAge,
			Long maxAge) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minPlayer = minPlayer;
		this.maxPlayer = maxPlayer;
		this.minAge = minAge;
		this.maxAge = maxAge;
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

	public Long getMinPlayer() {
		return minPlayer;
	}

	public void setMinPlayer(Long minPlayer) {
		this.minPlayer = minPlayer;
	}

	public Long getMaxPlayer() {
		return maxPlayer;
	}

	public void setMaxPlayer(Long maxPlayer) {
		this.maxPlayer = maxPlayer;
	}

	public Long getMinAge() {
		return minAge;
	}

	public void setMinAge(Long minAge) {
		this.minAge = minAge;
	}

	public Long getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Long maxAge) {
		this.maxAge = maxAge;
	}
	
	
}
