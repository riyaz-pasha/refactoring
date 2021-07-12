package example1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRentals(Rental rental) {
        this.rentals.add(rental);
    }

    public String statement() {
        Double totalAmount = Double.valueOf(0);
        int frequentRenterPoints = 0;
        Enumeration _rentals = rentals.elements();
        String result = String.format("Rental Record for %s \n", this.getName());
        while (_rentals.hasMoreElements()) {
            Double thisAmount = Double.valueOf(0);
            Rental eachRental = (Rental) _rentals.nextElement();

            switch (eachRental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (eachRental.getDaysRented() > 2) thisAmount += (eachRental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += eachRental.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (eachRental.getDaysRented() > 3) thisAmount += (eachRental.getDaysRented() - 2) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (eachRental.getMovie().getPriceCode() == Movie.NEW_RELEASE && eachRental.getDaysRented() > 1)
                frequentRenterPoints++;
            result += "\t" + eachRental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
