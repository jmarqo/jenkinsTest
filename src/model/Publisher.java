package model;

/**
 * <h3>Publisher</h3>
 * Clase para guardar los nombres de las empresas que publican los juegos
 * @version 1.0
 * @since 06/09/2020
 * @author Eva y Christian
 */
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
