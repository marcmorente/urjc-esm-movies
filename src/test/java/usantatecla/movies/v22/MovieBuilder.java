package usantatecla.movies.v22;

public class MovieBuilder {

	private String title;
	
	private Price price;
	
	public MovieBuilder() {
		this.title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder children() {
		this.price = new ChildrenPrice();
		return this;
	}
	
	public MovieBuilder regular() {
		this.price = new RegularPrice();
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.price = new NewReleasePrice();
		return this;
	}
	
	public Movie build() {
		return new Movie(title, price);
	}
}
