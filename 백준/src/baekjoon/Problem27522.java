package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem27522 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final List<Racer> racers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final String time = st.nextToken();
            final String name = st.nextToken();
            racers.add(new Racer(time, name));
        }

        racers.sort(Comparator.comparing(r -> r.time));

        int blue = 0;
        int red = 0;

        int score = 10;
        for (int i = 0; i < 8; i++) {
            if ("B".equals(racers.get(i).team)) {
                blue += score;
            } else {
                red += score;
            }

            if (i < 2) {
                score -= 2;
            } else {
                score--;
            }
        }

        int rankBlue = 0;
        int rankRed = 0;
        int rank = 1;
        for (Racer racer : racers) {
            if ("B".equals(racer.team)) {
                rankBlue += rank;
            } else {
                rankRed += rank;
            }

            rank++;
        }

        if (blue > red) {
            System.out.println("Blue");
        } else if (blue < red) {
            System.out.println("Red");
        } else {
            System.out.println(rankBlue > rankRed ? "Blue" : "Red");
        }
    }

    private static class Racer {
        String time;
        String team;

        public Racer(final String time, final String team) {
            this.time = time;
            this.team = team;
        }
    }
}
