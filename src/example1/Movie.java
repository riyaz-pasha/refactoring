package example1;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private String title;
    Price priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return this.priceCode.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                this.priceCode = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                this.priceCode = new NewReleasePrice();
                break;
            case Movie.CHILDREN:
                this.priceCode = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code");
        }
    }

    public Double getCharge(int daysRented) {
        return this.priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return this.priceCode.getFrequentRenterPoints(daysRented);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", priceCode=" + priceCode +
                '}';
    }
}
