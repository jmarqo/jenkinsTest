package data;

import java.util.ArrayList;
import java.util.List;
import model.Game;

/**
 * <h3>GamesImpl</h3>
 * Clase que implementa la interfaz <i>Games</i>
 * @version 1.0
 * @since 06/09/2020
 * @author Eva y Christian
 */
public class GamesImpl implements Games{

	private static List<Game> gameList = new ArrayList<Game>();
	
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
	public boolean deleteGame(Game game) {
		
		if(gameList.remove(gameList.indexOf(game)) != null)
			return true;
		
		return false;
	}


	
}
