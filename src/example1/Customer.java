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
        Enumeration _rentals = rentals.elements();
        String result = String.format("Rental Record for %s \n", this.getName());
        while (_rentals.hasMoreElements()) {
            Rental eachRental = (Rental) _rentals.nextElement();
            result += "\t" + eachRental.getMovie().getTitle() + "\t" + String.valueOf(eachRental.getCharge()) + "\n";
        }

        result += "Amount owed is " + this.getTotalCharge() + "\n";
        result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private Double getTotalCharge() {
        Double result = 0D;
        Enumeration _rentals = rentals.elements();
        while (_rentals.hasMoreElements()) {
            Rental eachRental = (Rental) _rentals.nextElement();
            result = eachRental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration _rentals = rentals.elements();
        while (_rentals.hasMoreElements()) {
            Rental eachRental = (Rental) _rentals.nextElement();
            result += eachRental.getFrequentRenterPoints();
        }
        return result;
    }
}
