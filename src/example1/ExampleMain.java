package example1;

public class ExampleMain {
    public static void main(String[] args) {
        Movie bahubali1 = new Movie("Bahubali 1", Movie.REGULAR);
        Movie bahubali2 = new Movie("Bahubali 2", Movie.NEW_RELEASE);
        Rental rentalBahubali1 = new Rental(bahubali1, 5);
        Rental rentalBahubali2 = new Rental(bahubali2, 5);
        Customer customer = new Customer("Riyaz");
        customer.setRentals(rentalBahubali1);
        customer.setRentals(rentalBahubali2);
        System.out.println(customer.statement());
    }
}
