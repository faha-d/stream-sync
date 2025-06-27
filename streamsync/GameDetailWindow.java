package streamsync;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.List;

public class GameDetailWindow {
    private Game game;
    private List<Game> watchLaterList;
    private static List<Game> likedList = new java.util.ArrayList<>();
    private static List<Game> watchlist = new java.util.ArrayList<>();

    public GameDetailWindow(Game game, List<Game> watchLaterList, List<Game> watchHistory) {
        this.game = game;
        this.watchLaterList = watchLaterList;
    }

    public void show() {
        Stage detailStage = new Stage();
        detailStage.setTitle(game.getTitle());

        Label titleLabel = new Label(game.getTitle());
        titleLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");

        WebView trailer = new WebView();
        trailer.setPrefHeight(500);
        trailer.setPrefWidth(600);
        trailer.getEngine().load(game.getYoutubeUrl());

        Button watchLater = new Button("Add to Watch Later");
        Button likeBtn = new Button("Like");


        watchLater.setOnAction(e -> {
            if (!watchLaterList.contains(game)) {
                watchLaterList.add(game);
                new Alert(Alert.AlertType.INFORMATION, game.getTitle() + " added to Watch Later!").showAndWait();
            }
        });

        likeBtn.setOnAction(e -> {
            if (!likedList.contains(game)) {
                likedList.add(game);
                new Alert(Alert.AlertType.INFORMATION, "You liked " + game.getTitle()).showAndWait();
            }
        });


        VBox layout = new VBox(15, titleLabel, trailer, watchLater, likeBtn);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #282a36;");

        Scene scene = new Scene(layout, 700, 600);
        detailStage.setScene(scene);
        detailStage.show();
    }

    public static List<Game> getLikedList() {
        return likedList;
    }

    public static List<Game> getWatchlist() {
        return watchlist;
    }
}
