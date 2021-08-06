package services;

import java.util.List;
import model.Game;
import model.Genre;
import model.Publisher;


public interface ServicesGame {

	public List<Game> getGames();
	
	public boolean addGame(Game g);
	
	public boolean deleteGame(int index);
	
	public boolean editGame(Game g, int index);
	
	public List<Game> getGamesByDate(int year);
	
	public List<Game> getGamesByGenre(Genre genre);
	
	public List<Publisher> getPublishers();
	
	public List<Game> getGamesByPublisher(Publisher publisher);
	
	public List<Game> getGamesSXX();
	
	public List<Game> getGamesEvenYear();
	
	public List<Game> getGamesNintendo();
	
}
