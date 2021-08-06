package data;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import model.Game;
import model.Genre;
import model.Platform;
import model.Release;
import model.Publisher;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImporterImpl implements Importer{

	private Games games = new GamesImpl();
	private Publishers publishers = new PublishersImpl();
	private final static Logger LOGGER = Logger.getLogger("data.ImporterImpl");

	@Override
	public void importCSV() {

		File f = null;
		FileReader fr;
		BufferedReader br;

		try {

			// Leer fichero

			f = new File("vgsales.csv");

			if (!f.exists()) 
				throw new FileNotFoundException();

				// Abrir lector

				fr = new FileReader(f);
				br = new BufferedReader(fr);

				// Recorrer cada l�nea del fichero

				String line;

				br.readLine();

				while((line = br.readLine()) != null) {

					// Dividir la l�nea con el separador ","
					String[] lineSplit = line.split(",");

					// Guardar los datos en objeto game

					Game g = new Game();
					Release rel = new Release();
					Publisher pub = new Publisher();

					g.setName(lineSplit[1]);

					Platform pla = getPlatform(lineSplit[2]);

					rel.setPlatform(pla);
					rel.setYear(Integer.parseInt(lineSplit[3]));

					g.setRelease(rel);

					g.setGenre(getGenre(lineSplit[4]));

					pub.setName(lineSplit[5]);

					g.setPublisher(pub);

					// A�adir a la lista games el objeto

					games.addGame(g);

					// Guardar los datos en objeto publisher

					List<Publisher> pubList= publishers.getPublishers();

					if (pubList.size() == 0)
						// A�adir publisher a la lista
						pubList.add(pub);

					boolean estaEnLista = false;

					int ii = 0;

					while(!estaEnLista && ii < pubList.size()) {

						if(pubList.get(ii).equals(pub))
							estaEnLista = true;
						ii++;
					}

					// A�adir publisher a la lista
					if (!estaEnLista)
						pubList.add(pub);

				}


		}  catch(FileNotFoundException fnfe) {
			
			LOGGER.log(Level.INFO, "No se ha encontrado fichero CSV para importar");
		
		} catch(Exception e){
			
			LOGGER.log(Level.SEVERE, "No se ha podido cargar el fichero");
			
		}

	}


	public Platform getPlatform(String name) {

		for(Platform p: Platform.values()) {
			if(p.getConsole().equals(name))
				return p;

		}

		return null;

	}

	public Genre getGenre(String name) {

		for(Genre g: Genre.values()) {
			if(g.getName().equals(name))
				return g;
		}

		return null;
	}


}
