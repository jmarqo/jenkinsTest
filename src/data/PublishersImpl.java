package data;

import java.util.List;

import model.Publisher;

public class PublishersImpl implements Publishers{

	private static List<Publisher> publishersList;
	
	@Override
	public List<Publisher> getPublishers() {
		
		return publishersList;
	}

	
}
