package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder {

    private String name;
    private List<Rental> rentals;

    public CustomerBuilder() {
        this.rentals = new ArrayList<Rental>();
        this.name = "customerName";
    }

    public CustomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder rental(Rental rental) {
        this.rentals.add(rental);
        return this;
    }

    public Customer build() {
        Customer customer = new Customer(this.name);
        for (Rental rental : this.rentals) {
            customer.addRental(rental);
        }
        return customer;
    }
}
