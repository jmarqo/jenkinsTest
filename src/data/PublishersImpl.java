package data;

import java.util.ArrayList;
import java.util.List;

import model.Publisher;

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
