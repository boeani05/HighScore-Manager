# Simple Java Highscore Manager (Konsolenanwendung)
![Java Logo](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Git & GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
## Kurzbeschreibung
Dies ist eine interaktive Konsolenanwendung in Java, die entwickelt wurde, um die Grundlagen der Dateiverarbeitung (File I/O) und des Java Collections Frameworks zu erlernen und zu verinnerlichen. Sie bietet Funktionen zum Speichern, Anzeigen, Zurücksetzen und Analysieren von Highscores in einem dynamischen und robusten Kontext.
## Hintergrund & Lernziele
Dieses Projekt entstand als praktischer Teil des Java-Roadmaps von roadmap.sh. Es dient dazu, essentielle Java-Konzepte in einer praxisnahen Anwendung zu festigen, insbesondere:
*   **Dateioperationen:** Umgang mit Dateisystemen zum Speichern und Laden von Daten.
*   **Java Collections Framework:** Effektive Nutzung von dynamischen Datenstrukturen wie `ArrayList` und `HashSet`.
*   **Objektorientiertes Design:** Strukturierung der Anwendung in modulare Klassen und Methoden.
*   **Fehlerbehandlung:** Entwicklung robuster Anwendungen durch das Abfangen und Reagieren auf Ausnahmen.
*   **Moderne Java-Features:** Einsatz von Records und `java.nio.file` API.
## Implementierte Funktionen
*   **Highscore hinzufügen:** Ermöglicht das Eingeben eines Spielernamens und eines Scores, die dann im Anhangsmodus (`append mode`) in einer `highscores.txt`-Datei gespeichert werden.
*   **Highscores anzeigen:** Liest alle Highscores aus der `highscores.txt`-Datei, parst sie in `HighscoreEntry`-Objekte, sammelt sie in einer `ArrayList` und gibt sie anschließend formatiert in der Konsole aus.
*   **Highscores zurücksetzen:** Löscht die `highscores.txt`-Datei, um die gesamte Highscore-Liste zu leeren.
*   **Einzigartige Spieler anzeigen:** Eine dedizierte Funktion, die alle Highscores aus der `highscores.txt`-Datei liest und daraus ein `Set` mit allen **einzigartigen Spielernamen** extrahiert und zurückgibt.
*   **Interaktives Konsolenmenü:** Eine benutzerfreundliche Menüführung über die Kommandozeile zur Auswahl der verschiedenen Aktionen.
*   **Robuste Fehlerbehandlung:** Fängt `IOException` bei Dateizugriffen, `InputMismatchException` bei fehlerhaften Benutzereingaben und `NumberFormatException` beim Parsen von Scores ab, um die Anwendung stabil und benutzerfreundlich zu halten.
## Verwendete Technologien und Konzepte
*   **Java (Core):**
    *   Grundlegende Syntax, Schleifen (`while`, Enhanced For-Loop), Bedingungen (`if-else`, `switch`).
    *   Datentypen (`String`, `int`, `boolean`), String-Manipulation (`split()`).
*   **Objektorientierte Programmierung (OOP):**
    *   Klassen (`HighscoreManager`), Objekte, Methoden, Attribute, Konstruktoren.
    *   **Java `record` (`HighscoreEntry`):** Verwendung eines modernen Java-Records für eine kompakte und effiziente Datenklasse.
*   **Java Collections Framework:**
    *   **`ArrayList<HighscoreEntry>`:** Dynamische, typisierte Liste zum Speichern und Verwalten von `HighscoreEntry`-Objekten (z.B. in `displayHighscores()`).
    *   **`HashSet<String>`:** Eine Collection, die ausschließlich einzigartige `String`-Objekte speichert (z.B. für `getUniquePlayerNames()`).
    *   **`List` und `Set` Interfaces:** Verwendung der Interfaces für die Typdeklaration (`List<...>`, `Set<...>`) für mehr Flexibilität und Best Practices.
*   **Dateioperationen (File I/O):**
    *   **Traditionell (`java.io`):** `FileWriter`, `BufferedWriter` (für `addHighscore()`), `FileReader`, `BufferedReader` (für `displayHighscores()`), `File` Klasse (`delete()`).
    *   **Modern (`java.nio.file`):** `Path`, `Files.exists()`, `Files.readAllLines()` (für `getUniquePlayerNames()`) für einen moderneren und oft effizienteren Dateizugriff.
    *   **`try-with-resources`:** Für sicheres und automatisches Schließen von Datei-Ressourcen.
*   **Exception Handling:** Umgang mit `IOException`, `InputMismatchException`, `NumberFormatException` zur Erhöhung der Anwendungsstabilität.
*   **`java.util.Scanner`:** Für die Verarbeitung von Benutzereingaben in der Konsole.
*   **Refactoring:** Prozess der Code-Verbesserung und Integration neuer Konzepte in bestehende Strukturen.
## Wie man das Projekt ausführt
1.  **Klone das Repository:**
    ```bash
    git clone https://github.com/boeani05/HighScore-Manager.git
    cd HighScore-Manager
    ```
2.  **Öffne das Projekt in einer Java-IDE:**
    Importiere das Projekt in deine bevorzugte Java-Entwicklungsumgebung (z.B. IntelliJ IDEA, Eclipse, VS Code).
3.  **Führe die `main`-Methode aus:**
    Starte die `main`-Methode in der Datei `HighscoreManager.java`.
4.  **Interagiere über die Konsole:**
    Befolge die Anweisungen des Menüs in der Konsole, um Highscores hinzuzufügen, anzuzeigen, zurückzusetzen oder einzigartige Spieler aufzulisten.
## Zukünftige Erweiterungen
*   **Sortierung der Highscores:** Implementierung einer Sortierfunktion für die `ArrayList` der Highscores (z.B. nach Score, nach Name), was die Konzepte von `Comparable`/`Comparator` und `Collections.sort()` einführen würde.
*   **Weitere Collection-Typen:** Integration und Erkundung von `Map` (für Schlüssel-Wert-Paare wie Spieler-ID zu Highscore) oder `Queue`.
*   **Datenpersistent mit JSON/CSV:** Speicherung der Highscores in einem strukturierteren Format (z.B. JSON oder CSV) anstelle von einfachen Textzeilen.
*   **Grafische Benutzeroberfläche (GUI):** Erweiterung des Projekts um eine visuelle Schnittstelle (z.B. mit JavaFX oder Swing).
*   **Unit Tests:** Schreiben von Tests für die `HighscoreManager`-Methoden, um die Korrektheit der Logik zu gewährleisten.
