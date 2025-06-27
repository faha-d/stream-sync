package streamsync;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class SignUpScreen {
    private Stage stage;
    private UserManager userManager;

    public SignUpScreen(Stage stage, UserManager userManager) {
        this.stage = stage;
        this.userManager = userManager;
    }

    public void show() {
        Label title = new Label("Create an Account");
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        title.setTextFill(Color.WHITE);
        
        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");
   
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button signupBtn = new Button("Sign Up");
        Button backToLogin = new Button("Back to Login");

        VBox layout = new VBox(15, title, nameField, emailField, passwordField, signupBtn, backToLogin);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getStyleClass().add("signup-pane");

        signupBtn.setOnAction(e -> {
            try {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String pass = passwordField.getText().trim();

                if (name.isEmpty() || email.isEmpty() || pass.isEmpty())
                    throw new Exception("All fields are required.");

                userManager.registerCustomer(name, email, pass);
                showAlert("Success", "Account created! Please login.");
                new LoginScreen(stage, userManager).show();
            } catch (Exception ex) {
                showAlert("Error", ex.getMessage());
            }
        });

        backToLogin.setOnAction(e -> new LoginScreen(stage, userManager).show());

        Scene scene = new Scene(layout, 420, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
        stage.setScene(scene);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
