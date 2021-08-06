package model;

public class Game {

	private String name;
	private Release release;
	private Genre genre;
	private Publisher publisher;
	
	public Game() {
		
	}
	public Game(String name, Release release, Genre genre, Publisher publisher) {
		super();
		this.name = name;
		this.release = release;
		this.genre = genre;
		this.publisher = publisher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Release getRelease() {
		return release;
	}
	public void setRelease(Release release) {
		this.release = release;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Game [name=" + name + ", release=" + release + ", genre=" + genre + ", publisher=" + publisher + "]";
	}
	
}