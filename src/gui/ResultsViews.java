package gui;

import java.util.List;

import model.Game;
import model.Publisher;

/**
 * <b>ResultsViews</b>
 * Visualizado de las listas
 * @version 1.0
 * @since 06/09/2020
 * @author F.Javier e Ismael
 */
public class ResultsViews {
	
	/**
	 * Muestra una lista en consola con todos los juegos que recibe por parametro
	 * @param games Lista de juegos que se desea mostrar
	 */
	public static void showGamesList(List<Game> games) {
		
		int i = 1;
		System.out.println("   Name | Platform | Year | Genre | Publisher");
		for(Game game : games) {
			System.out.println();
			System.out.print(i+". "+game.getName()+" | ");
			System.out.print(game.getRelease().getPlatform().getConsole()+" | ");
			System.out.print(game.getRelease().getYear()+" | ");
			System.out.print(game.getGenre().getName()+" | ");
			System.out.print(game.getPublisher().getName()+" | ");
			i++;
		}
	}
	
	/**
	 * Muestra una lista con todos los creadfores de videojuegos que recibe por parametro
	 * @param publishers Lista de creadores de videojuegos 
	 */
	public static void showPublishersList(List<Publisher> publishers) {
		int i = 1;
		System.out.println("   Name");
		for(Publisher p : publishers) {
			System.out.println(i+". "+p.getName());
			i++;
		}
	}

}
