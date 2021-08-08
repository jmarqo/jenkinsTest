package data;

import java.util.ArrayList;
import java.util.List;

import model.Publisher;

/**
 * <h3>PublishersImpl</h3>
 * Clase que implementa la interfaz <i>Publishers</i>
 * @version 1.0
 * @since 06/09/2020
 * @author Eva y Christian
 */
public class PublishersImpl implements Publishers{

	private static List<Publisher> publishersList = new ArrayList<Publisher>();
	@Override
	public List<Publisher> getPublishers() {
		
		return publishersList;
	}

	public static void setPublishersList(List<Publisher> publishersList) {
		PublishersImpl.publishersList = publishersList;
	}

	
}
