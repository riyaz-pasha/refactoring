package example1;

public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    public Double getCharge(int daysRented) {
        Double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
