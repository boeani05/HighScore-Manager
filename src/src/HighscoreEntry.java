public record HighscoreEntry(String player, int score) {

    @Override
    public String toString() {
        return String.format("""
                        === Highscore for %s ===
                        \t%d points\s
                       \s""",
                this.player,
                this.score
        );
    }
}
