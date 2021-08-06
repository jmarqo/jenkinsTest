package control;

import java.awt.List;
import java.util.ArrayList;

import gui.MenuViews;
import gui.ResultsViews;
import model.Genre;
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
				showDateInput();
				showMainMenu();
				break;
			case 4:
				showPublisherList();
				showMainMenu();
				break;
			case 5:
				showConsoleMenu();
				showMainMenu();
				break;
			case 6:
				showNintendoGames();
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
		
	}
	
	public static void showDateInput() {
		//
	}
	
	public static void showXXCenturyGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesSXX();
		ResultsViews.showGamesList(gameList);
	}
	
	public static void showEvenYearGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesEvenYear();
		ResultsViews.showGamesList(gameList);
	}
	
	public static void showPublisherList() {}
	
	public static void showConsoleMenu() {}
	
	public static void showNintendoGames() {}
	
	/*
	 * 1. lista de juegos completa
	 * 2. por genero (elegir genero)
	 * 3. por fecha (introducir fecha. opción even)
	 * 4. lista de creadores
	 * 5. por consola (elegir consola)
	 * */

}
