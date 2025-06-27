package streamsync;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class GameCard {
    private VBox view;

    public GameCard(Game game, Runnable onClick) {
        // Load cover image
        ImageView cover = new ImageView();
        try {
            Image image = new Image(game.getImageUrl(), 200, 200, true, true);
            cover.setImage(image);
            cover.setFitWidth(200);
            cover.setFitHeight(200);
            cover.setPreserveRatio(true);
        } catch (Exception e) {
            System.out.println("Failed to load image for " + game.getTitle());
        }

        Label title = new Label(game.getTitle());
        title.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");

        Label desc = new Label(game.getType());
        desc.setWrapText(true);
        desc.setStyle("-fx-text-fill: #cccccc;");

        view = new VBox(10, cover, title, desc);
        view.setPrefSize(200, 280);
        view.setStyle("-fx-background-color:#1a1a1a; -fx-border-radius:8; -fx-background-radius:8;");
        view.setAlignment(Pos.CENTER);
        view.setPadding(new Insets(10));
        view.setCursor(Cursor.HAND);

        view.setOnMouseClicked(e -> onClick.run());
    }

    public VBox getView() {
        return view;
    }
}
