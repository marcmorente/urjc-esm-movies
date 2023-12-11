package usantatecla.movies.v22;

public abstract class Price {

	private static final int FREQUENT_RENTER_POINTS = 1;

	protected static final double EXTRA_CHARGE = 1.5;
	
	public abstract double getCharge(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented) {
		return Price.FREQUENT_RENTER_POINTS;
	}
}
