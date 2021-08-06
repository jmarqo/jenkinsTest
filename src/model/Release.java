package model;

public class Release {

	private Platform platform;
	private int year;
	
	public Release() {
		super();
	}
	public Release(Platform platform, int year) {
		super();
		this.platform = platform;
		this.year = year;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Release [platform=" + platform + ", year=" + year + "]";
	}

}
