package services;

import java.util.List;

import data.Games;
import data.GamesImpl;
import model.Game;
import model.Genre;
import model.Publisher;

public class ServicesGameImpl implements ServicesGame{

	private Games games = new GamesImpl();
	
	@Override
	public List<Game> getGames() {
		
		return games.getGames();
	}

	@Override
	public boolean addGame(Game g) {
		
		return games.addGame(g);
	}

	@Override
	public boolean deleteGame(int index) {
		
		return games.deleteGame(index);
	}

	@Override
	public boolean editGame(Game g, int index) {
		
		return games.editGame(g, index);
	}

	@Override
	public List<Game> getGamesByDate(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesByGenre(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publisher> getPublishers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesByPublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesSXX() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesEvenYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesNintendo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
