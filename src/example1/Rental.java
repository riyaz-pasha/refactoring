package example1;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Double getCharge() {
        return this.getMovie()
                .getCharge(this.getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return this.getMovie()
                .getFrequentRenterPoints(this.getDaysRented());
    }

}
