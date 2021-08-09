package control;

import java.util.ArrayList;

import gui.MenuViews;
import gui.ResultsViews;
import model.Genre;
import model.Publisher;
import model.Game;
import services.ServicesGameImpl;
import utilities.Listener;
import data.ImporterImpl;
/**
 * <b>MenuController</b>
 * Controlador del menu
 * @version 1.0
 * @since 06/09/2020
 * @author F.Javier e Ismael
 */
public class MenuController {
	
	private static ServicesGameImpl services = new ServicesGameImpl();
	
	/**
	 * Muestra el menu principal de la aplicación
	 */
	public static void showMainMenu() {
		
		importData();
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
	
	/**
	 * Muestra una lista con todos los juegos almacenados 
	 */
	public static void showGamesList() {
		ResultsViews.showGamesList(services.getGames());
		System.out.println("\nPulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	/**
	 * Muestra una lista con todos los géneros de los juegos (sin repetir)
	 */
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
		System.out.println("\nPulse 'Enter' para volver al menú principal.");
		Listener.getString();
		
		
	}
	
	
	/**
	 * Muestra una lista con todos los juegos del siglo XX 
	 */
	public static void showXXCenturyGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesSXX();
		ResultsViews.showGamesList(gameList);
		System.out.println("\nPulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	/**
	 * Muestra una lista con todos los juegos de años pares
	 */
	public static void showEvenYearGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesEvenYear();
		ResultsViews.showGamesList(gameList);
		System.out.println("\nPulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	/**
	 * Muestra una lista con todos los creadores de videojuegos
	 */
	public static void showPublisherList() {
		ArrayList<Publisher> publisherList = (ArrayList<Publisher>) services.getPublishers();
		ResultsViews.showPublishersList(publisherList);
		System.out.println("\nPulse 'Enter' para volver al menú principal.");
		Listener.getString();
		
	}
	
	/**
	 * Muestra una lista con todos los juegos de Nintendo
	 */
	public static void showNintendoGames() {
		ArrayList<Game> gameList = (ArrayList<Game>) services.getGamesNintendo();
		ResultsViews.showGamesList(gameList);
		System.out.println("\nPulse 'Enter' para volver al menú principal.");
		Listener.getString();
	}
	
	/**
	 * Importa los datos de un CSV a local
	 */
	public static void importData() {
		new ImporterImpl().importCSV();
	}

}
