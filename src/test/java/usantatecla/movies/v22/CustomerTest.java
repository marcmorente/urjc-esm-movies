package usantatecla.movies.v22;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void withoutRentalsTest() {
        Customer customer = new CustomerBuilder().build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .totalAmount(0)
                .frequentRenterPoints(0)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void regularRental1DayTest() {
        Movie movie = new MovieBuilder()
                .regular()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(1)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 2)
                .totalAmount(2)
                .frequentRenterPoints(1)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void regularRental2DayTest() {
        Movie movie = new MovieBuilder()
                .regular()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(2)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 2)
                .totalAmount(2)
                .frequentRenterPoints(1)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void regularRental3DayTest() {
        Movie movie = new MovieBuilder()
                .regular()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(3)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 3.5)
                .totalAmount(3.5)
                .frequentRenterPoints(1)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental1DayTest() {
        Movie movie = new MovieBuilder()
                .newRelease()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(1)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 3)
                .totalAmount(3)
                .frequentRenterPoints(1)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental2DayTest() {
        Movie movie = new MovieBuilder()
                .newRelease()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(2)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 3)
                .totalAmount(3)
                .frequentRenterPoints(2)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental3DayTest() {
        Movie movie = new MovieBuilder()
                .newRelease()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(3)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 3)
                .totalAmount(3)
                .frequentRenterPoints(2)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void childrenRental1DayTest() {
        Movie movie = new MovieBuilder()
                .children()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(1)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 1.5)
                .totalAmount(1.5)
                .frequentRenterPoints(1)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void childrenRental3DayTest() {
        Movie movie = new MovieBuilder()
                .children()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(3)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 1.5)
                .totalAmount(1.5)
                .frequentRenterPoints(1)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void childrenRental4DayTest() {
        Movie movie = new MovieBuilder()
                .children()
                .build();
        Rental rental = new RentalBuilder()
                .movie(movie)
                .daysRented(4)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(rental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(movie.getTitle(), 6)
                .totalAmount(6)
                .frequentRenterPoints(1)
                .build();

        assertEquals(result, statement);
    }

    @Test
    public void rentalTest() {
        String regularMovieName = "regularMovieName";
        Movie regularMovie = new MovieBuilder()
                .title(regularMovieName)
                .regular()
                .build();
        Rental regularRental = new RentalBuilder()
                .movie(regularMovie)
                .daysRented(10)
                .build();
        String newReleaseMovieName = "newReleaseMovieName";
        Movie newReleaseMovie = new MovieBuilder()
                .title(newReleaseMovieName)
                .newRelease()
                .build();
        Rental newReleaseRental = new RentalBuilder()
                .movie(newReleaseMovie)
                .daysRented(10)
                .build();
        String childrenMovieName = "childrenMovieName";
        Movie childrensMovie = new MovieBuilder()
                .title(childrenMovieName)
                .children()
                .build();
        Rental childrensRental = new RentalBuilder()
                .movie(childrensMovie)
                .daysRented(10)
                .build();
        Customer customer = new CustomerBuilder()
                .rental(regularRental)
                .rental(newReleaseRental)
                .rental(childrensRental)
                .build();
        String statement = customer.statement();
        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(regularMovieName, 14)
                .movie(newReleaseMovieName, 3)
                .movie(childrenMovieName, 15)
                .totalAmount(32)
                .frequentRenterPoints(4)
                .build();

        assertEquals(result, statement);
    }
}
