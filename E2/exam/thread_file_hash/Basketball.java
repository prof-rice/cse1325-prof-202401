import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

class ScoreBoard {
    private int points;
    public ScoreBoard() {
        this.points = 0;
    }
    public int score() {
        int shot = Math.random() < 0.8 ? 2 : 3;
        this.points += shot;
        return shot;
    }
    @Override
    public String toString() {
        return String.format("%3d", points);
    }
}
class Player {
    private String name;
    private int jersey;
    private double percentage;
    private int points;
    public static boolean playBall = false;
    public Player(String name, int jersey, double percentage) {
        this.name = name;
        this.jersey = jersey;
        this.percentage = percentage;
    }
    public Player(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.jersey = Integer.parseInt(br.readLine());
        this.percentage = Double.parseDouble(br.readLine());
    }
    public void sleep() {
        try {
            Thread.sleep((int) (Math.random() * 1800.0 + 1200.0));
        } catch(InterruptedException e) {
            System.err.println(name + " was interrupted!");
        }
    }
    public void play(ScoreBoard score) {
        while(!playBall) sleep();
        while(playBall) {
            if(Math.random() < percentage) { // score!
                System.out.println(this + " scores!");
                synchronized(score) {
                    this.points += score.score();
                }
            }
            sleep();
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, jersey);
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || !(o instanceof Player)) return false;
        Player p = (Player) o;
        return name.equals(p.name)
            && jersey == p.jersey;
    }
    @Override
    public String toString() {
        return name + " (" + jersey 
            + ((playBall || points == 0) ? ")" : ") with " + points + " points");
    }
}

class Team {
    private String name;
    private Set<Player> players;
    private Thread[] threads;
    public Team(BufferedReader br) throws IOException {
        this.name = br.readLine();
        players = new HashSet<>();
        for(int i=0; i<5; ++i) players.add(new Player(br));
    }
    public void play(ScoreBoard score) {
        if(threads != null) stop();
        threads = new Thread[5];
        int i = 0;
        for(Player p : players) {
            threads[i] = new Thread(() -> p.play(score));
            threads[i++].start();
        }
    }
/*  // Or, using ArrayList<Thread> threads,
    public void play(ScoreBoard score) {
        threads = new ArrayList<>(); 
        for(Player p : players) {
            Thread t = new Thread(() -> p.play(score));
            threads.add(t);
            t.start();
        }
    }
*/
    public void stop() {
        for(Thread t : threads) {
            try {
                t.join();
            } catch(InterruptedException e) {
                System.err.println("Interuption: " + name + " " + t);
            }
        }
        threads = null;
    }
    @Override
    public String toString() {
        return name;
    }
    public String toStringFullTeam() {
        StringBuilder sb = new StringBuilder("Team " + name);        
        for(Player p : players) sb.append("\n  " + p);
        return sb.toString(); 
    }
}

public class Basketball {
    private Team[] teams;
    private ScoreBoard[] scores;
    int clock;
    public Basketball(String[] args) throws IOException {
        if(teams.length != 2) 
            throw new IllegalArgumentException("Need exactly 2 teams!");
        teams = new Team[2];
        scores = new ScoreBoard[2];
        for(int i=0; i<2; ++i) {
            scores[i] = new ScoreBoard();
            try(BufferedReader br = new BufferedReader(new FileReader(args[i]))) {
                teams[i] = new Team(br);
            } catch(IOException e) {
                System.err.println("Unable to load player: " + e);
                teams[i] = null;
            }
        }
        if(teams[0] == null || teams[1] == null) 
            throw new IOException("Not enough teams");
    }
    private void showScoreBoard() {
        System.out.printf("Clock: %3d:%02d  ScoreBoard: %8s %s  %8s %s\n",
                           clock / 10, clock % 10, teams[0], scores[0], teams[1], scores[1]);
    }
    public void playGame() {
        for(int i=0; i<2; ++i) {
            teams[i].play(scores[i]);
            System.out.println(teams[i].toStringFullTeam());
        }
        clock = 400;
        showScoreBoard();
        Player.playBall = true;
        while(clock > 0) {
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.err.println("Interrupted: playGame loop");
            }
            clock -= 1;
            if(clock % 10 == 0) showScoreBoard();
        }
        Player.playBall = false; 
        for(int i=0; i<2; ++i) {
            teams[i].stop();
            System.out.println(teams[i].toStringFullTeam());
        }
    }
    public static void main(String[] args) {
        try {
            Basketball bb = new Basketball(args);
            bb.playGame();
        } catch(IOException e) {
            System.err.println("Game is cancelled: " + e);
            // e.printStackTrace();
        } catch(Exception e) {
            System.err.println("Unexpected exception: " + e);
            e.printStackTrace();
        }
    }
}
