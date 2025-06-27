package streamsync;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class LoginScreen {
    private Stage stage;
    private UserManager userManager;

    public LoginScreen(Stage stage, UserManager userManager) {
        this.stage = stage;
        this.userManager = userManager;
    }

    public void show() {
        Label title = new Label("Welcome to GameStore.pk");
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        title.setTextFill(Color.WHITE);

        TextField emailField = new TextField();
        PasswordField passwordField = new PasswordField();
        emailField.setPromptText("Email");
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        Button signupBtn = new Button("New to GameStore? Sign Up") ;

        Hyperlink showAdminLink = new Hyperlink("Are you an admin?");
        showAdminLink.setOnAction(e -> new AdminLoginScreen(stage).show());

        VBox layout = new VBox(15, title, emailField, passwordField, loginBtn, signupBtn,showAdminLink);
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("login-pane");

        loginBtn.setOnAction(e -> {
            try {
                String email = emailField.getText().trim();
                String pass = passwordField.getText().trim();
                if (email.isEmpty() || pass.isEmpty()) throw new Exception("All fields are required");

                Customer customer = userManager.authenticate(email, pass);
                if (customer != null) {
                    showAlert("Login Success", "Welcome " + customer.getName());
                    new CustomerDashboard(stage, customer).show();
                } else {
                    throw new Exception("Invalid email or password.");
                }
            } catch (Exception ex) {
                showAlert("Error", ex.getMessage());
            }
        });

        signupBtn.setOnAction(e -> new SignUpScreen(stage, userManager).show());

        Scene scene = new Scene(layout, 420, 550);
        scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
