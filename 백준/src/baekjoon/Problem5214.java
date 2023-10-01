package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5214 {

    private static int N;
    private static int K;
    private static int M;
    private static List<List<Integer>> tubeToStation;
    private static List<List<Integer>> stationToTube;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tubeToStation = new ArrayList<>();
        stationToTube = new ArrayList<>();

        for (int i = 0; i <= M; i++) {
            tubeToStation.add(new ArrayList<>());
        }

        for (int i = 0; i <= N; i++) {
            stationToTube.add(new ArrayList<>());
        }

        for (int tube = 1; tube <= M; tube++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                final int station = Integer.parseInt(st.nextToken());
                tubeToStation.get(tube).add(station);
                stationToTube.get(station).add(tube);
            }
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        final PriorityQueue<Station> pq = new PriorityQueue<>(Comparator.comparing(s -> s.route));
        pq.add(new Station(1, 1));

        final boolean[] isVisitedStation = new boolean[N + 1];
        final boolean[] isVisitedTube = new boolean[M + 1];

        while (!pq.isEmpty()) {
            final Station cur = pq.poll();

            if (cur.name == N) {
                return cur.route;
            }

            isVisitedStation[cur.name] = true;

            for (final Integer tube : stationToTube.get(cur.name)) {
                if (isVisitedTube[tube]) {
                    continue;
                }

                isVisitedTube[tube] = true;
                for (final Integer stationName : tubeToStation.get(tube)) {
                    isVisitedStation[stationName] = true;
                    pq.add(new Station(stationName, cur.route + 1));
                }
            }
        }

        return -1;
    }

    private static class Station {
        int name;
        int route;

        public Station(final int name, final int route) {
            this.name = name;
            this.route = route;
        }
    }
}
