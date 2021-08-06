package data;

import java.util.List;
import model.Game;


public class GamesImpl implements Games{

	private static List<Game> gameList;
	
	@Override
	public  List<Game> getGames() {
		
		return gameList;
	}

	@Override
	public boolean addGame(Game g) {
		
		if(gameList.add(g))  
			return true;
		
		return false;
		
	}

	@Override
	public boolean editGame(Game g, int index) {
		
		gameList.add(index, g);
		
		if(gameList.get(index).equals(g))
			
			return true;
		
		return false;
	}

	@Override
	public boolean deleteGame(int index) {
		
		if(gameList.remove(index) != null)
			return true;
		
		return false;
	}

	
}
