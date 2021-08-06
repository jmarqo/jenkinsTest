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

			// Recorrer cada línea del fichero

			String line;
			br.readLine();

			while((line = br.readLine()) != null) {
				
				int jj = 0; // contador 

				// Dividir la línea con el separador ","
				String[] lineSplit = line.split(",");

				// Guardar los datos en objeto game

				Game g = new Game();
				Release rel = new Release();
				Publisher pub = new Publisher();

				if (lineSplit[1].indexOf('"')>=0) {
					
					int kk = complexNameLength(lineSplit);
					
					g.setName(getComplexName(lineSplit, kk));
					
					jj = kk - 1;
					
				} else {
				
					g.setName(lineSplit[1]);
				}

				Platform pla = getPlatform(lineSplit[2+jj]);

				rel.setPlatform(pla);
				
				try {
					rel.setYear(Integer.parseInt(lineSplit[3+jj]));
				} catch(NumberFormatException nfe){
					//LOGGER.log(Level.SEVERE, "Formato de año incorrecto");
					rel.setYear(0);
				}

				g.setRelease(rel);

				g.setGenre(getGenre(lineSplit[4+jj]));

				pub.setName(lineSplit[5+jj]);

				g.setPublisher(pub);

				// Añadir a la lista games el objeto

				games.addGame(g);

				// Guardar los datos en objeto publisher

				List<Publisher> pubList= publishers.getPublishers();

				if (pubList.size() == 0)
					// Añadir publisher a la lista
					pubList.add(pub);

				boolean estaEnLista = false;

				int ii = 0;

				while(!estaEnLista && ii < pubList.size()) {

					if(pubList.get(ii).equals(pub))
						estaEnLista = true;
					ii++;
				}

				// Añadir publisher a la lista
				if (!estaEnLista)
					pubList.add(pub);

			}


		}  catch(FileNotFoundException fnfe) {

			LOGGER.log(Level.INFO, "No se ha encontrado fichero CSV para importar");

		} catch(Exception e){

			LOGGER.log(Level.SEVERE, "No se ha podido cargar el fichero " + e);

		}

	}


	public Platform getPlatform(String name) {

		for(Platform p: Platform.values()) {
			if(p.getConsole().equals(name)) {
				return p;
			}

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

	
	public int complexNameLength(String[] a) {
		
		int ii = 2;
		
		while (a[ii].indexOf('"') < 0) {
			ii++;
		}
		
		return ii;
	}
	
	public String getComplexName(String[] a, int kk) {
		
		String r = a[1];
		
		for(int ii = 2; ii <= kk; ii++) {
			
			r += ", " + a[ii];	
		}
		
		return r;
		
	}

}
