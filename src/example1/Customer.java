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
            Rental eachRental = (Rental) _rentals.nextElement();
            
            frequentRenterPoints++;

            if (eachRental.getMovie().getPriceCode() == Movie.NEW_RELEASE && eachRental.getDaysRented() > 1)
                frequentRenterPoints++;
            result += "\t" + eachRental.getMovie().getTitle() + "\t" + String.valueOf(eachRental.getCharge()) + "\n";
            totalAmount += eachRental.getCharge();
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
