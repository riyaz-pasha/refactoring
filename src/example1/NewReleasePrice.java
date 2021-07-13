package example1;

public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public Double getCharge(int daysRented) {
        return Double.valueOf(daysRented * 3);
    }
}
