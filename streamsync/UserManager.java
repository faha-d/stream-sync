package streamsync;

import java.io.*;
import java.util.ArrayList;

public class UserManager {
    private ArrayList<Customer> customers = new ArrayList<>();
    private static final String FILE_PATH = "users.csv";

    public UserManager() {
        loadUsers();
    }

    public void registerCustomer(String name, String email, String password) {
        customers.add(new Customer(name, email, password));
        saveUsers();
    }

    public Customer authenticate(String email, String password) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email) && c.checkPassword(password)) {
                return c;
            }
        }
        return null;
    }

    private void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Customer c : customers) {
                writer.println(c.toCSV());
            }
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    customers.add(new Customer(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }
}
