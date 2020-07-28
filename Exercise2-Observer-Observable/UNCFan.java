public class UNCFan implements GameObserver{
    public void update(Game game, String whoScored) {
        if (whoScored.equals("UNC")) {
            if (game.whoIsWinning().equals("UNC")) {
                System.out.println("GO HEELS!");
            } else {
                System.out.println("Good job Carolina, keep playing hard.");
            }
        } else {
            System.out.println("Stay tough UNC");
        }
    }
}
