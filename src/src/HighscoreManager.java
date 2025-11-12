import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HighscoreManager {
    public static void main(String[] args) {
        HighscoreManager manager = new HighscoreManager();
        Scanner scanner = new Scanner(System.in);
        int input;
        String playerName;
        int playerScore;
        boolean isLoopTrue = true;

        while (isLoopTrue) {
            System.out.println("""
                    
                    1. Highscore hinzufügen
                    2. Highscores anzeigen
                    3. Highscores zurücksetzen
                    4. User anzeigen
                    5. Beenden
                    """);
            while (true) {
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Bitte gib eine Zahl ein!");
                    scanner.next();
                    scanner.nextLine();
                }
            }
            switch (input) {
                case 1:
                    System.out.println("Gib den Namen des Spielers ein: ");
                    playerName = scanner.nextLine();
                    System.out.println("Gib die Punktzahl des Spielers ein: ");
                    playerScore = scanner.nextInt();
                    manager.addHighscore(new HighscoreEntry(playerName, playerScore));
                    break;
                case 2:
                    manager.displayHighscores();
                    break;
                case 3:
                    manager.resetHighscores();
                    break;
                case 4:
                    System.out.println("--- Einzigartige Spieler ---\n");
                    System.out.println(manager.getUniquePlayerNames());
                    break;
                case 5:
                    isLoopTrue = false;
            }
        }
        scanner.close();
    }

    private static final String FILENAME = "highscores.txt";

    public void addHighscore(HighscoreEntry entry) {
        try (FileWriter fileWriter = new FileWriter(FILENAME, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            writer.write(entry.player() + "," + entry.score());
            writer.newLine();

            System.out.println("Highscore erfolgreich gespeichert: " + entry.player() + " - " + entry.score());
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern des Highscores: " + e.getMessage());
        }
    }

    public void displayHighscores() {
        File file = new File(FILENAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("Noch keine Highscores vorhanden.");
            return;
        }

        System.out.println("\n--- Aktuelle Highscores ---");

        List<HighscoreEntry> highscores = new ArrayList<>();
        try (
                FileReader fileReader = new FileReader(FILENAME);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    try {
                        String playerName = parts[0];
                        int score = Integer.parseInt(parts[1]);
                        HighscoreEntry newHighScore = new HighscoreEntry(playerName, score);
                        highscores.add(newHighScore);
                    } catch (NumberFormatException e) {
                        System.err.println("Fehler: Ungültiger Score in Zeile übersprungen: " + line + " (" + e.getMessage() + ")");
                    }
                } else {
                    System.out.println("Fehler: Ungültiger Highscore-Eintrag übersprungen: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Highscores: " + e.getMessage());
        }

        if (highscores.isEmpty()) {
            System.out.println("Keine gültigen Highscores zum Anzeigen gefunden.");
        } else {
            int count = 1;
            for (HighscoreEntry highscore : highscores) {

                System.out.printf("%d. %s%n", count++, highscore.player() + ": " + highscore.score() + " Punkte");

            }
        }
        System.out.println("---------------------------\n");
    }

    public void resetHighscores() {
        File file = new File(FILENAME);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Highscore-Datei erfolgreich zurückgesetzt.");
            } else {
                System.err.println("Fehler beim Zurücksetzen der Highscore-Datei.");
                System.err.println("Möglicherweise ist die Datei in Verwendung oder es fehlen Berechtigungen.");
            }
        } else {
            System.out.println("Es gibt keine Highscore-Datei zum Zurücksetzen.");
        }
    }

    public Set<String> getUniquePlayerNames() {
        Set<String> uniqueEntries = new HashSet<>();
        List<String> allFileLines = new ArrayList<>();

        Path highscorePath = Path.of(FILENAME);

        if (!Files.exists(highscorePath)) {
            System.out.println("Es gibt noch keine eingetragenen Highscores!");
            return uniqueEntries;
        }

        try {
            allFileLines = Files.readAllLines(highscorePath);
        } catch (IOException e) {
            System.err.println("Die Highscore-Datei konnte nicht gefunden werden!");
        }

        for (String fileLine : allFileLines) {
            String[] parts = fileLine.split(",");
            if (parts.length == 2) {
                    String playerName = parts[0];
                    uniqueEntries.add(playerName);
            }
        }
        return uniqueEntries;
    }
}
