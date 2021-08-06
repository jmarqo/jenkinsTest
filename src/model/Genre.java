package model;

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
