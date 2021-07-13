package example1;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    public Double getCharge(int daysRented) {
        Double result = Double.valueOf(2);
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
