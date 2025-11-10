import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                    4. Beenden
                    """);
            while (true) {
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("Bitte gib eine Zahl ein!");
                    scanner.next();
                    scanner.nextLine();
                }
            }
            switch (input) {
                case 1:
                    System.out.println("Gib den Namen des Spielers ein: ");
                    playerName = scanner.next();
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
            writer.write(entry.getPlayer() + "," + entry.getScore());
            writer.newLine();

            System.out.println("Highscore erfolgreich gespeichert: " + entry.getPlayer() + " - " + entry.getScore());
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

        try (
                FileReader fileReader = new FileReader(FILENAME);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String line;
            int count = 1;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    System.out.printf("%d. %s: %s Punkte\n", count++, parts[0], parts[1]);
                } else {
                    System.out.println("Ungültiger Highscore-Eintrag übersprungen: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Highscores: " + e.getMessage());
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
}
