package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

    public String statement() {
        String result = "Rental Record for " + this.getName() + "\n";
        result += this.rentalDetails();
        result += "Amount owed is " + this.getTotalCharge() + "\n";
        result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private String rentalDetails() {
        String rentalDetails = "";
        for (Rental rental : this.rentals) {
            rentalDetails += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
        }
        return rentalDetails;
    }

    private double getTotalCharge() {
		double result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getCharge();
        }
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getFrequentRenterPoints();
        }
		return result;
	}
}
