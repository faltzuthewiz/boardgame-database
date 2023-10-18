package s23.boardgameDatabase.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class BoardGame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=100)
	private String title;
	
	@NotNull
	@Size(min=2, max=1000)
	private String description;
	
	@NotNull
	@Min(1)
	private long minPlayer;
	
	@Min(0)
	@Max(20)
	private long maxPlayer;
	
	@NotNull
	@Min(3)
	@Max(30)
	private long minAge;
	
	
	// @Min(10)
	@Max(180)
	private long estDuration;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name = "languageId")
	private Language language;
	
	
	public BoardGame() {}
	/*
	public BoardGame(String title, String description, long minPlayer, long maxPlayer, long minAge, Category category, Genre genre) {
		this.title = title;
		this.description = description;
		this.minPlayer = minPlayer;
		this.maxPlayer = maxPlayer;
		this.minAge = minAge;
		this.category = category;
		this.genre = genre;
	} */

	public BoardGame(@NotNull @Size(min = 2, max = 100) String title,
			@NotNull @Size(min = 2, max = 1000) String description, @NotNull @Min(1) long minPlayer,
			@Min(0) @Max(20) long maxPlayer, @NotNull @Min(3) @Max(30) long minAge,
			/*@Min(10) */ @Max(180) long estDuration, Category category, Genre genre, Language language) {
		this.title = title;
		this.description = description;
		this.minPlayer = minPlayer;
		this.maxPlayer = maxPlayer;
		this.minAge = minAge;
		this.estDuration = estDuration;
		this.category = category;
		this.genre = genre;
		this.language = language;
	}

	// Without the maxPlayer value
	public BoardGame(String title, String description, long minPlayer, long minAge) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public long getEstDuration() {
		return estDuration;
	}

	public void setEstDuration(long estDuration) {
		this.estDuration = estDuration;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
	
}
