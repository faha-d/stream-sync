package streamsync;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class AdminDashboard {
    private Stage stage;
    private ArrayList<Game> games;

    public AdminDashboard(Stage stage) {
        this.stage = stage;
        this.games = GameManager.loadGamesFromCSV();
    }

    public void show() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #1e1e2f;");

        Label header = new Label("Admin Dashboard - Manage Games");
        header.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");

        Button backBtn = new Button("Back to Login");
        backBtn.setOnAction(e -> new LoginScreen(stage, new UserManager()).show());

        VBox gameList = new VBox(10);
        refreshGameList(gameList);

        layout.getChildren().addAll(header, gameList, backBtn);

        Scene scene = new Scene(layout, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

    private void refreshGameList(VBox container) {
        container.getChildren().clear();

        for (Game game : games) {
            HBox row = new HBox(10);
            row.setAlignment(Pos.CENTER_LEFT);

            Label title = new Label(game.getTitle() + " (" + game.getType() + ")");
            title.setStyle("-fx-text-fill: white;");

            Button delete = new Button("Delete");
            delete.setOnAction(e -> {
                games.remove(game);
                refreshGameList(container);
            });

            row.getChildren().addAll(title, delete);
            container.getChildren().add(row);
        }
    }
}
