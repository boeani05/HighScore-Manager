🏆 Highscore Manager
📖 Problem

Ein Spiel soll die erreichten Punktzahlen der Spieler auch nach dem Beenden speichern und anzeigen können.
Dazu müssen Highscores dauerhaft gespeichert, ausgelesen und zurückgesetzt werden.

💡 Lösung

Die Highscores werden in einer Textdatei (highscores.txt) gespeichert.
Die Datei wird über File Operations in Java verwaltet:

Schreiben: Neue Highscores werden in die Datei eingefügt.

Lesen: Alle Highscores werden zeilenweise ausgelesen und angezeigt.

Löschen: Die Datei wird geleert (nicht gelöscht).

Die Dateioperationen nutzen try-with-resources und java.nio.file.Files mit UTF-8-Encoding, um Speicherlecks und fehlerhafte Zeichen zu vermeiden.

💻 Beispielcode
Files.write(Path.of("highscores.txt"),
    List.of("Alice,120", "Bob,90"),
    StandardCharsets.UTF_8,
    StandardOpenOption.CREATE,
    StandardOpenOption.TRUNCATE_EXISTING);

List<String> lines = Files.readAllLines(Path.of("highscores.txt"), StandardCharsets.UTF_8);
lines.forEach(System.out::println);

📚 Gelerntes

Wie man Dateien in Java liest, schreibt und leert.

Warum Files + UTF-8 robuster sind als FileReader/FileWriter.

Wie try-with-resources garantiert, dass Streams sicher geschlossen werden.

⚠️ Typischer Fehler

Alte I/O-Klassen (FileReader, FileWriter) verwenden → falsches Encoding, offene Handles.

Datei löschen statt leeren → Race Conditions.

Kein try-with-resources → Ressourcenlecks.
