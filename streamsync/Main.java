package streamsync;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        UserManager userManager = new UserManager();
        new LoginScreen(stage, userManager).show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
