public class HighscoreEntry {
    private String player;
    private int score;

    public HighscoreEntry(String player, int score) {
        this.player = player;
        this.score = score;
    }

    public String getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("""
                === Highscore for %s ===
                \t%d points 
                """,
                this.player,
                this.score
        );
    }
}
