package control;

import gui.MenuViews;
import utilities.Listener;

public class MenuController {
	
	public static void showMainMenu() {
		
		System.out.flush();
		MenuViews.showMainMenu();
		
		try {
			
			int option = Listener.getInt();
			System.out.println(option);
			
		}catch(java.util.InputMismatchException i) {
			
			showMainMenu();
			
		}
		
	}
	
	public static void showGamesList() {}
	
	public static void showGenresMenu() {}
	
	public static void showDateInput() {}
	
	public static void showPublisherMenu() {}
	
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
