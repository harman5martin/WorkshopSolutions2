import java.util.ArrayList;
import java.util.List;

public class GameClass implements Game {
    private String home;
    private String visitor;
    private int homeScore;
    private int visitorScore;
    private String sport;

    private List<GameObserver> fans;

    public GameClass(String gameType, String visitingTeam, String homeTeam) {
        sport = gameType;
        home = homeTeam;
        visitor = visitingTeam;
        homeScore = 0;
        visitorScore = 0;

        fans = new ArrayList<GameObserver>();
    }

    public void addObserver(GameObserver observer) {
        fans.add(observer);
    }

    public void deleteObserver(GameObserver observer) {
        fans.remove(observer);
    }

    public void notifyObservers(String whoScored) {
        // Trigger update method on
        // all observers with forEach loop
        for (GameObserver observer : fans) {
            observer.update(this, whoScored);
        }
    }

    public void scorePoints(String team, int points) {
        if (home.equals(team)) {
            homeScore += points;
        } else if (visitor.equals(team)) {
            visitorScore += points;
        }
        notifyObservers(team);
    }

    public void printScore() {
        System.out.println(sport + ": " + visitor + " " + visitorScore + " - " + homeScore + " " + home);
    }

    public String whoIsWinning() {
        if (homeScore > visitorScore) {
            return home;
        } else if (homeScore < visitorScore) {
            return visitor;
        }
        return "Tie Game";
    }
}
