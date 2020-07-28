import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Game[] games = new Game[3];
        games[0] = new GameClass("Basketball", "Duke", "UNC");
        games[1] = new GameClass("Baseball", "UNC" , "NCState");
        games[2] = new GameClass("Lacrosse", "Georgetown", "UNC");
        games[3] = new GameClass("Football", "UNC", "Virginia");
        games[4] = new GameClass("Basketball", "Kentucky", "UNC");

        UNCFan uncFan = new UNCFan();

        for (Game g : games) {
            g.addObserver(uncFan);
        }

        while (s.hasNext()) {
            int gameIndex = s.nextInt();

            String team = s.next();
            int points = s.nextInt();

            games[gameIndex].scorePoints(team, points);
            games[gameIndex].printScore();
        }
    }
}
