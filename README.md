Aktualisierung: Integration von ArrayList und verbesserte Eingabe (2025.11.10)

Die Methode displayHighscores() wurde umfassend überarbeitet: Highscores werden nun aus der Datei gelesen, in HighscoreEntry-Objekte geparst und zuerst in einer ArrayList<HighscoreEntry> gesammelt. Erst danach erfolgt die Ausgabe, was die Grundlage für Sortier- oder Filterfunktionen legt.
Fehlerbehandlung beim Parsen von Scores (NumberFormatException) wurde hinzugefügt, um ungültige Daten in der Highscore-Datei abzufangen.
Die Benutzereingabe in der main-Methode wurde robuster gestaltet, indem das Lesen von Zahlen und Text durch korrekte Handhabung von Zeilenumbrüchen (scanner.nextLine() nach nextInt()) konsolidiert wurde.
