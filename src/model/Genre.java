package model;

/**
 * <h3>Genre</h3>
 * Enumerador con toda la lista de plataformas
 * @version 1.0
 * @since 06/09/2020
 * @author Eva y Christian
 */
public enum Genre {
	Sports("Sports"),
	Platform("Platform"),
	Racing("Racing"),
	RolePlaying("Role-Playing"),
	Puzzle("Puzzle"),
	Misc("Misc"),
	Shooter("Shooter"),
	Simulation("Simulation"),
	Action("Action"),
	Fighting("Fighting"),
	Adventure("Adventure"),
	Strategy("Strategy");
	
	private String name;
	
	private Genre(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
