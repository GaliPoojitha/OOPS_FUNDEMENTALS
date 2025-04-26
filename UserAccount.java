// Encapsulation - User class
class User {
    private String name;
    private int id;

    // Constructor
    User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter for User
    public void getUser() {
        System.out.println("User name is: " + name + ", id is: " + id);
    }
}

// Inheritance - Abstract class for Payment details
abstract class PaymentDetails {
    int bill;

    // Constructor for PaymentDetails class
    PaymentDetails(int bill) {
        this.bill = bill;
    }

    abstract void billPaid();  // Abstract method

    // Getter for bill
    public void getBill() {
        System.out.println("Bill: " + bill);
    }
}

// Interface - Charges
interface Charges {
    static final int serviceCharge = 12;
    static final int gst = 13;

    // Default method to calculate charges
    default int charge() {
        return serviceCharge + gst;
    }

    // Abstract method
    void totalCharges(int bill);
}

// Payment class implementing PaymentDetails and Charges interface
class Payment extends PaymentDetails implements Charges {

    // Constructor for Payment
    Payment(int bill) {
        super(bill);  // Calling the constructor of PaymentDetails
    }

    // Overriding totalCharges method from Charges interface
    @Override
    public void totalCharges(int bill) {
        int addon = charge();
        System.out.println("Total Amount to be paid: " + (addon + bill));
    }

    // Implementing the abstract method from PaymentDetails
    @Override
    public void billPaid() {
        System.out.println("Bill Paid");
    }

    // Method overloading (Polymorphism)
    public void billPaid(boolean owner) {
        System.out.println("Bill not required for owner");
    }
}

// Main class to test
public class UserAccount {
    public static void main(String[] args) {
        // Creating an instance of User
        User user = new User("Pooji", 123);
        user.getUser();  // Display user info

        // Creating an instance of Payment
        Payment payment = new Payment(135);  // Passing bill amount to constructor
        payment.totalCharges(135);  // Calculating total charges

        // Calling overloaded methods
        payment.billPaid();
        payment.billPaid(true);
    }
}
