package streamsync;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;

public class CustomerDashboard {
    private Stage stage;
    private Customer customer;
    private List<Game> watchLaterList = new ArrayList<>();
    private List<Game> watchHistory = new ArrayList<>();

    public CustomerDashboard(Stage stage, Customer customer) {
        this.stage = stage;
        this.customer = customer;
    }

    public void show() {
        Label nameLabel = new Label("Welcome, " + customer.getName());
        nameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        Button watchLaterBtn = new Button("Watch Later");
        Button likedBtn = new Button("Liked Trailers");
        Button logoutBtn = new Button("Logout");
        // Sidebar layout
        VBox sidebar = new VBox(10, nameLabel, watchLaterBtn, likedBtn, logoutBtn);
        sidebar.setPadding(new Insets(20));
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.setStyle("-fx-background-color: #1e1e2f; -fx-pref-width: 300px;");

        logoutBtn.setOnAction(e -> new LoginScreen(stage, new UserManager()).show());
        watchLaterBtn.setOnAction(e -> showWatchLater());
        likedBtn.setOnAction(e -> new LikedVideoScreen(GameDetailWindow.getLikedList()).show());

        // Game cards layout
        FlowPane gamePane = new FlowPane();
        gamePane.setPadding(new Insets(50));
        gamePane.setHgap(20);
        gamePane.setVgap(20);

        ArrayList<Game> games = GameManager.loadGamesFromCSV();
        for (Game game : games) {
            GameCard card = new GameCard(game, () -> openGameDetail(game));
            gamePane.getChildren().add(card.getView());
        }

        ScrollPane scroll = new ScrollPane(gamePane);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background: transparent;");

        // Main layout
        BorderPane layout = new BorderPane();
        layout.setLeft(sidebar);
        layout.setCenter(scroll);
        layout.setStyle("-fx-background-color: linear-gradient(to bottom right, #1e1e2f, #282a36);");

        Scene scene = new Scene(layout, 1100, 600);
        stage.setScene(scene);
        stage.setTitle("Gamestore.pk - Dashboard");
        stage.show();
    }

    private void openGameDetail(Game game) {
        new GameDetailWindow(game, watchLaterList, watchHistory).show();
    }

    private void showWatchLater() {
        Stage stage = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #1e1e2f;");

        Label error = new Label("Your Watch Later list is empty.");
        error.setTextFill(Color.WHITE);
        if (watchLaterList.isEmpty()) {
            layout.getChildren().add(error);
        } else {
            for (Game g : watchLaterList) {
                Label lbl = new Label(g.getTitle() + " - " + g.getType());
                lbl.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
                layout.getChildren().add(lbl);
            }
        }

        Scene scene = new Scene(layout, 500, 300);
        stage.setTitle("Watch Later");
        stage.setScene(scene);
        stage.show();
    }
}
