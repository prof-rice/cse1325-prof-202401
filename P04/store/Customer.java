package store;

public class Customer {
    public Customer(String name, String email) {
        int at = email.indexOf("@");
        int dot = email.indexOf(".", at+1);
        if(at < 0 || dot < 0) 
            throw new  IllegalArgumentException("Invalid email address: " + email);
        this.name = name;
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format("%s (%s)", name, email);
    }
    private String name;
    private String email;
}
