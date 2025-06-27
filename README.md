# Stream Sync

Stream Sync (GameStore.pk) is a JavaFX-based desktop application that allows users to browse, watch, and manage game trailers. The application supports user registration, login, and provides separate dashboards for customers and admins.

## Features

- **User Registration & Login:** Users can sign up and log in with their credentials.
- **Admin Login:** Admins can log in with a dedicated account to manage games.
- **Game Dashboard:** Browse a list of games with cover images, types, and trailers.
- **Watch Later:** Add games to a personal "Watch Later" list.
- **Liked Trailers:** Like game trailers and view your liked list.
- **Admin Dashboard:** Admins can view and delete games from the catalog.
- **Persistent Storage:** User and game data are stored in CSV files.

## Project Structure

```
streamsync/           # Java source code (main app, screens, logic)
resources/
└── games.csv         # Game data (title, type, trailer URL, image URL)
users.csv             # User data (name, email, password)
styles/
└── app.css           # JavaFX CSS styles
lib/                  # JavaFX and plugin libraries
README.md
.gitignore
```

## How to Run

1. **Requirements:**
   - Java 8 or higher
   - JavaFX libraries (included in `lib/`)

2. **Compile:**
   ```
   javac -cp "lib/*" streamsync/*.java
   ```

3. **Run:**
   ```
   java -cp ".:lib/*" streamsync.Main
   ```

## Default Admin Credentials

- **Email:** `admin@gamestore.pk`
- **Password:** `admin321`

## Data Files

- **users.csv:** Stores registered users.
- **resources/games.csv:** Stores game information.

## License

This project is for educational purposes only and is licensed under the MIT License. See the `LICENSE` file for details.

