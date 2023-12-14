package usantatecla.movies.v22;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private String customerName;
    private String movieName;

    @Before
    public void init() {
        this.customerName = "customerName";
        this.movieName = "movieName";
    }

    @Test
    public void withoutRentalsTest() {
        Customer customer = new CustomerBuilder().build();
        String result = this.buildStatementWithoutRentals(customer);

        assertEquals(result, customer.statement());
    }

    @Test
    public void regularRental1DayTest() {
        Movie movie = this.buildRegularMovie();
        Rental rental = this.buildRental(movie, daysRented(1));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(2), frequentRenterPoints(1));

        assertEquals(result, statement);
    }

    @Test
    public void regularRental2DayTest() {
        Movie movie = this.buildRegularMovie();
        Rental rental = this.buildRental(movie, daysRented(2));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(2), frequentRenterPoints(1));

        assertEquals(result, statement);
    }

    @Test
    public void regularRental3DayTest() {
        Movie movie = this.buildRegularMovie();
        Rental rental = this.buildRental(movie, daysRented(3));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(3.5), frequentRenterPoints(1));

        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental1DayTest() {
        Movie movie = this.buildNewReleaseMovie();
        Rental rental = this.buildRental(movie, daysRented(1));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(3), frequentRenterPoints(1));

        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental2DayTest() {
        Movie movie = this.buildNewReleaseMovie();
        Rental rental = this.buildRental(movie, daysRented(2));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(3), frequentRenterPoints(2));

        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental3DayTest() {
        Movie movie = this.buildNewReleaseMovie();
        Rental rental = this.buildRental(movie, daysRented(3));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(3), frequentRenterPoints(2));

        assertEquals(result, statement);
    }

    @Test
    public void childrenRental1DayTest() {
        Movie movie = this.buildChildrenMovie();
        Rental rental = this.buildRental(movie, daysRented(1));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(1.5), frequentRenterPoints(1));

        assertEquals(result, statement);
    }

    @Test
    public void childrenRental3DayTest() {
        Movie movie = this.buildChildrenMovie();
        Rental rental = this.buildRental(movie, daysRented(3));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(1.5), frequentRenterPoints(1));

        assertEquals(result, statement);
    }

    @Test
    public void childrenRental4DayTest() {
        Movie movie = this.buildChildrenMovie();
        Rental rental = this.buildRental(movie, daysRented(4));
        Customer customer = this.buildCustomerWithRental(rental);
        String statement = customer.statement();
        String result = this.buildStatementWithSameTotalAmount(amount(6), frequentRenterPoints(1));

        assertEquals(result, statement);
    }

    @Test
    public void rentalTest() {
        String regularMovieName = "regularMovieName";
        Movie regularMovie = this.buildRegularMovie(regularMovieName);
        Rental regularRental = this.buildRental(regularMovie, daysRented(10));
        String newReleaseMovieName = "newReleaseMovieName";
        Movie newReleaseMovie = this.buildNewReleaseMovie(newReleaseMovieName);
        Rental newReleaseRental = this.buildRental(newReleaseMovie, daysRented(10));
        String childrenMovieName = "childrenMovieName";
        Movie childrensMovie = this.buildChildrenMovie(childrenMovieName);
        Rental childrensRental = this.buildRental(childrensMovie, daysRented(10));
        Customer customer = new CustomerBuilder()
                .rental(regularRental)
                .rental(newReleaseRental)
                .rental(childrensRental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(regularMovieName, amount(14))
                .movie(newReleaseMovieName, amount(3))
                .movie(childrenMovieName, amount(15))
                .totalAmount(32)
                .frequentRenterPoints(4)
                .build();

        assertEquals(result, statement);
    }

    private String buildStatementWithoutRentals(Customer customer) {
        return new StatementBuilder()
                .customerName(this.customerName)
                .totalAmount(0)
                .frequentRenterPoints(0)
                .build();
    }

    private Movie buildRegularMovie() {
        return new MovieBuilder()
                .regular()
                .build();
    }

    private Movie buildRegularMovie(String title) {
        return new MovieBuilder()
                .title(title)
                .regular()
                .build();
    }

    private Rental buildRental(Movie movie, int daysRented) {
        return new RentalBuilder()
                .movie(movie)
                .daysRented(daysRented)
                .build();
    }

    private Customer buildCustomerWithRental(Rental rental) {
        return new CustomerBuilder()
                .rental(rental)
                .build();
    }

    private String buildStatementWithSameTotalAmount(double amount, int frequentRenterPoints) {
        return new StatementBuilder()
                .customerName(this.customerName)
                .movie(this.movieName, amount)
                .totalAmount(amount)
                .frequentRenterPoints(frequentRenterPoints)
                .build();
    }

    private int daysRented(int daysRented) {
        return daysRented;
    }

    private double amount(double amount) {
        return amount;
    }

    private int frequentRenterPoints(int frequentRenterPoints) {
        return frequentRenterPoints;
    }

    private Movie buildNewReleaseMovie() {
        return new MovieBuilder()
                .newRelease()
                .build();
    }

    private Movie buildNewReleaseMovie(String title) {
        return new MovieBuilder()
                .title(title)
                .newRelease()
                .build();
    }

    private Movie buildChildrenMovie() {
        return new MovieBuilder()
                .children()
                .build();
    }

    private Movie buildChildrenMovie(String title) {
        return new MovieBuilder()
                .title(title)
                .children()
                .build();
    }
}
