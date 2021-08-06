package data;

import java.util.List;

import model.Game;

public interface Games {

	public List<Game> getGames();
	
	public boolean addGame(Game g);
	
	public boolean editGame(Game g, int index);
	
	public boolean deleteGame(int index);
	
	
	
	
	
	
}
