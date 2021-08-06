package model;

public class Publisher {

	private String name;
	
	public Publisher() {
		
	}
	public Publisher(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Publisher [name=" + name + "]";
	}
	
}