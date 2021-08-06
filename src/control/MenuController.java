package control;

import java.awt.List;
import java.util.ArrayList;

import gui.MenuViews;
import gui.ResultsViews;
import model.Genre;
import model.Publisher;
import model.Game;
import services.ServicesGameImpl;
import utilities.Listener;

public class MenuController {
	
	private static ServicesGameImpl services = new ServicesGameImpl();
	
	public static void showMainMenu() {
		
		System.out.flush();
		MenuViews.showMainMenu();
		
		try {
			
			int option = Listener.getInt();
			System.out.println(option);
			
			switch(option) {
			case 1:
				showGamesList();
				showMainMenu();
				break;
			case 2:
				showGenresMenu();
				showMainMenu();
				break;
			case 3:
				showXXCenturyGames();
				showMainMenu();
				break;
			case 4:
				showEvenYearGames();
				showMainMenu();
				break;
			case 5:
				showNintendoGames();
				showMainMenu();
				break;
			case 6:
				showPublisherList();
				showMainMenu();
				break;
			case 0:
				break;
			default:
				System.out.println("Opción incorrecta.");
				showMainMenu();
			}
			
		}catch(java.util.InputMismatchException i) {
			System.out.println("Opción incorrecta.");
			showMainMenu();
			
		}
		
	}
	
	public static void showGamesList() {
		ResultsViews.showGamesList(services.getGames());
		System.out.println("Pulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	public static void showGenresMenu() {
		ArrayList<Genre> genreList = new ArrayList<>();
		for(Genre g : Genre.values()) {
			genreList.add(g);
		}
		MenuViews.showGenreMenu(genreList);
		int opcion = 0;
		Genre genre = null;
		
		try {
			opcion = Listener.getInt();
			genre = genreList.get(opcion-1);
		}catch(java.util.InputMismatchException im) {
			System.out.println("Formato no válido.");
			showGenresMenu();
		}catch( java.lang.IndexOutOfBoundsException io) {
			System.out.println("Opción no válida.");
			showGenresMenu();
		}
		
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesByGenre(genre);
		ResultsViews.showGamesList(gameList);
		System.out.println("Pulse 'Enter' para volver al menú principal.");
		Listener.getString();
		
		
	}
	
	public static void showDateInput() {
		//
	}
	
	public static void showXXCenturyGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesSXX();
		ResultsViews.showGamesList(gameList);
		System.out.println("Pulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	public static void showEvenYearGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesEvenYear();
		ResultsViews.showGamesList(gameList);
		System.out.println("Pulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	public static void showPublisherList() {
		ArrayList<Publisher> publisherList = (ArrayList<Publisher>) services.getPublishers();
		ResultsViews.showPublishersList(publisherList);
		System.out.println("Pulse 'Enter' para volver al menú principal.");
		Listener.getString();
		
	}
	
	//public static void showPlatformMenu() {}
	
	public static void showNintendoGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesNintendo();
		ResultsViews.showGamesList(gameList);
		System.out.println("Pulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	/*
	 * 1. lista de juegos completa
	 * 2. por genero (elegir genero)
	 * 3. por fecha (introducir fecha. opción even)
	 * 4. lista de creadores
	 * 5. por consola (elegir consola)
	 * */

}
