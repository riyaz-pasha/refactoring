package example1;

public abstract class Price {
    abstract int getPriceCode();

    abstract public Double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
