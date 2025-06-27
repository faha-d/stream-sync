package streamsync;

import java.io.*;
import java.util.ArrayList;

public class GameManager {
    public static ArrayList<Game> loadGamesFromCSV() {
        ArrayList<Game> games = new ArrayList<>();
        String filePath = "resources/games.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    games.add(new Game(parts[0], parts[1], parts[2], parts[3] ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading games file: " + e.getMessage());
        }

        return games;
    }
}
