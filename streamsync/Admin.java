package streamsync;

public class Admin extends User {
    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

    @Override
    public String toCSV() {
        return "";
    }
}
