package usantatecla.movies.v22;

public class RegularPrice extends Price {

	private static final double CHARGE = 2.0;
	private static final int DAYS_RENTED_THRESHOLD = 2;
	
	@Override
	public double getCharge(int daysRented) {
		double result = RegularPrice.CHARGE;
		if (daysRented > RegularPrice.DAYS_RENTED_THRESHOLD) {
			result += (daysRented - RegularPrice.DAYS_RENTED_THRESHOLD) * Price.EXTRA_CHARGE;
		}
		return result;
	}

}
