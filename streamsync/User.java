package streamsync;

public abstract class User {
    protected String name, email, password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public boolean checkPassword(String input) { return password.equals(input); }

    public abstract boolean isAdmin();
    public abstract String toCSV();
}
