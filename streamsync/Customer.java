package streamsync;

public class Customer extends User {
    public Customer(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public String toCSV() {
        return name + "," + email + "," + password;
    }
}
