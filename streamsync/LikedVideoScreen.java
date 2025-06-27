package streamsync;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class LikedVideoScreen {
    private List<Game> likedGames;

    public LikedVideoScreen(List<Game> likedGames) {
        this.likedGames = likedGames;
    }

    public void show() {
        Stage stage = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #1e1e2f;");

        Label header = new Label("❤️ Liked Trailers");
        header.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");
        layout.getChildren().add(header);

        if (likedGames.isEmpty()) {
            Label emptyLabel = new Label("You haven't liked any trailers yet.");
            emptyLabel.setStyle("-fx-text-fill: #ccc;");
            layout.getChildren().add(emptyLabel);
        } else {
            for (Game g : likedGames) {
                Label gameLabel = new Label(g.getTitle() + " - " + g.getType());
                gameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
                layout.getChildren().add(gameLabel);
            }
        }

        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Liked Videos");
        stage.setScene(scene);
        stage.show();
    }
}
