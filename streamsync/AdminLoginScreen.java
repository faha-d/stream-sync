package streamsync;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AdminLoginScreen {
    private Stage stage;

    public AdminLoginScreen(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Label title = new Label("Admin Login");
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        title.setTextFill(Color.WHITE);
        
        TextField emailField = new TextField();
        emailField.setPromptText("Admin Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");

        loginBtn.setOnAction(e -> {
        	try {
            String email = emailField.getText().trim();
            String pass = passwordField.getText().trim();

            if (email.isEmpty() || pass.isEmpty()) throw new Exception("All fields are required");
            
            if (email.equals("admin@gamestore.pk") && pass.equals("admin321")) {
                new AdminDashboard(stage).show();
            } else {
            	throw new Exception("Invalid email or password.");
            }}catch (Exception ex) {
                showAlert("Error", ex.getMessage());
        }});

        VBox layout = new VBox(10, title, emailField, passwordField, loginBtn);
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("login-pane");

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
