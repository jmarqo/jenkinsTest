package services;

import java.util.List;
import model.Game;
import model.Genre;
import model.Platform;
import model.Publisher;

/**
 * <b>ServicesGame</b>
 * Interfaz para el listado de juegos
 * @version 1.0
 * @since 06/09/2020
 * @author Eva y Christian
 */
public interface ServicesGame {

	/**
	 * Devuelve toda la lista de juegos
	 * @return Lista de juegos
	 */
	public List<Game> getGames();
	
	/**
	 * Devuelve una lista de juegos con el mismo nombre introducido
	 * @param name Nombre del juego del que se queire recuperar la lista
	 * @return Lista de juegos
	 */
	public List<Game> getGames(String name);
	
	/**
	 * Devuelve un juego especifico por nombr ey plataforma
	 * @param name Nombre del juego
	 * @param platform Plataforma del juego
	 * @return Juego
	 */
	public Game getGames(String name, Platform platform);
	
	/**
	 * Añade un juego a la lista
	 * @param game Juego que se queire añadir
	 * @return Valor verdaddero o falso si se ha añadido el juego
	 */
	public boolean addGame(Game game);
	
	/**
	 * Borra un juego de la lista
	 * @param game Juego que se desea borrar
	 * @return Valor verdaddero o falso si se ha borrado el juego
	 */
	public boolean deleteGame(Game game);
	
	/**
	 * Edita un juego de la lista
	 * @param game Juego editado
	 * @param index Posicion de la lista en la que deseamos guardarlo
	 * @return Valor verdaddero o falso si se ha editado el juego
	 */
	public boolean editGame(Game game, int index);
	
	/**
	 * Devuelve una lista de juegos de un años especifico
	 * @param year Año a buscar
	 * @return Lista de juegos
	 */
	public List<Game> getGamesByDate(int year);
	
	/**
	 * Devuelve una lista de juegos que sean de un genero
	 * @param genre Genero a buscar
	 * @return Lista de juegos
	 */
	public List<Game> getGamesByGenre(Genre genre);
	
	/**
	 * Devuelve todos los juegos de un publisher
	 * @param publisher Publisher de los juegos
	 * @return Lista de juegos
	 */
	public List<Game> getGamesByPublisher(Publisher publisher);
	
	/**
	 * Devuelve todos los juegos del Siglo XX
	 * @return Lista de juegos
	 */
	public List<Game> getGamesSXX();
	
	/**
	 * Devuelve todos los juegos lanzados en años pares
	 * @return Lista de juegos
	 */
	public List<Game> getGamesEvenYear();
	
	/**
	 * Devuelve todos los juegos para consolas de nintendo
	 * @return Lista de juegos
	 */
	public List<Game> getGamesNintendo();
	
	/**
	 * Devuelve todos los publishers de jeugos
	 * @return Lista de publishers
	 */
	public List<Publisher> getPublishers();
	
}
