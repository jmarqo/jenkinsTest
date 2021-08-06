package gui;

import java.util.List;

import model.Game;
import model.Publisher;

public class ResultsViews {
	
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
			
		}
	}
	
	public static void showPublishersList(List<Publisher> publishers) {
		int i = 1;
		System.out.println("   Name");
		for(Publisher p : publishers) {
			System.out.println(i+". "+p.getName());
		}
	}

}
