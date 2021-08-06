package services;

import java.util.ArrayList;
import java.util.List;

import data.Games;
import data.GamesImpl;
import data.Publishers;
import data.PublishersImpl;
import model.Game;
import model.Genre;
import model.Platform;
import model.Publisher;

public class ServicesGameImpl implements ServicesGame{

	private Games games = new GamesImpl();
	private Publishers publishers = new PublishersImpl();

	@Override
	public List<Game> getGames() {

		return games.getGames();
	}

	@Override
	public List<Game> getGames(String name) {

		List<Game> r = new ArrayList<Game>();	
		List<Game> games = getGames();

		// Buscar juegos por nombre
		for (int ii = 0; ii<games.size(); ii++) {

			if(games.get(ii).getName().equals(name))
				r.add(games.get(ii));

		}

		// Devolver la lista de juegos con ese nombre

		return r;
	}

	@Override
	public List<Game> getGames(String name, Platform platform) {

		List<Game> r = new ArrayList<Game>();	
		List<Game> games = getGames(name);

		// Buscar juegos por nombre
		for (int ii = 0; ii<games.size(); ii++) {

			if(games.get(ii).getRelease().getPlatform().equals(platform))
				r.add(games.get(ii));

		}

		// Devolver la lista de juegos con ese nombre

		return r;

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

		// obtener la lista de juegos

		List<Game> r = new ArrayList<Game>();	
		List<Game> games = getGames();

		// recorrer la lista de juegos

		for(int ii = 0; ii < games.size(); ii++) {

			// si el año coincide con el año del juego, guardarlo en la nueva lista
			if(games.get(ii).getRelease().getYear() == year) 
				r.add(games.get(ii));

		}


		return r;
	}

	@Override
	public List<Game> getGamesByGenre(Genre genre) {
		// obtener la lista de juegos

		List<Game> r = new ArrayList<Game>();	
		List<Game> games = getGames();

		// recorrer la lista de juegos


		for(int ii = 0; ii < games.size(); ii++) {

			// si el genero coincide con el genero del juego, guardarlo en la nueva lista
			if(games.get(ii).getGenre().equals(genre)) 
				r.add(games.get(ii));	

		}


		return r;
	}

	@Override
	public List<Publisher> getPublishers() {

		return publishers.getPublishers();
	}

	@Override
	public List<Game> getGamesByPublisher(Publisher publisher) {

		// obtener la lista de juegos

		List<Game> r = new ArrayList<Game>();	
		List<Game> games = getGames();

		// recorrer la lista de juegos

		for(int ii = 0; ii < games.size(); ii++) {

			// si el publisher coincide con el publisher del juego, guardarlo en la nueva lista
			if(games.get(ii).getPublisher().equals(publisher))
				r.add(games.get(ii));

		}

		return r;
	}

	@Override
	public List<Game> getGamesSXX() {

		List<Game> r = new ArrayList<Game>();

		List<Game> games = getGames();

		// Saber los años del siglo XX (funcion opcional)

		int start = 1901;
		int end  = 2001;

		for (int ii = start; ii < end; ii++) {

			// llamar a la funcion para todos esos años y añadir datos a la nueva lista
			r.addAll(getGamesByDate(ii));

		}

		return r;
	}

	@Override
	public List<Game> getGamesEvenYear() {

		List<Game> r = new ArrayList<Game>();

		List<Game> games = getGames();

		for (int ii = 0 ; ii < games.size() ; ii++) {

			// Saber si el año es par

			int resto;

			resto = games.get(ii).getRelease().getYear() % 2;

			// si es par llamar a la funcion para todos esos años y añadir datos a la nueva lista

			if (resto == 0)
				r.addAll(getGamesByDate(ii));
		}

		return r;
	}

	@Override
	public List<Game> getGamesNintendo() {

		List<Game> r = new ArrayList<Game>();

		List<Game> games = getGames();

		for (int ii = 0 ; ii < games.size() ; ii++) {

			// Saber si el juego es de una consola de nintendo y si es de nintendo añadirlo a la nueva lista

			if (games.get(ii).getRelease().getPlatform().getCompany().equals("Nintendo"))

				r.add(games.get(ii));		
		}

		return r;
	}



}
