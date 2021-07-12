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

            thisAmount = amountFor(eachRental);

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

    private Double amountFor(Rental aRental) {
        Double result = Double.valueOf(0);
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDaysRented() > 2) result += (aRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (aRental.getDaysRented() > 3) result += (aRental.getDaysRented() - 2) * 1.5;
                break;
        }
        return result;
    }
}
