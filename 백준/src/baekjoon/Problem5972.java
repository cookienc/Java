package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5972 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graphs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            final List<Node> lists = new ArrayList<>();
            graphs.add(lists);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken()) - 1;
            final int v = Integer.parseInt(st.nextToken()) - 1;
            final int w = Integer.parseInt(st.nextToken());

            graphs.get(u).add(new Node(v, w));
            graphs.get(v).add(new Node(u, w));
        }

        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        final PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.w));
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            final Node cur = pq.poll();
            final int cv = cur.v;
            final int cw = cur.w;

            if (distances[cv] < cw) {
                continue;
            }

            for (int i = 0; i < graphs.get(cv).size(); i++) {
                final Node next = graphs.get(cv).get(i);
                final int cost = distances[cv] + next.w;

                if (cost < distances[next.v]) {
                    distances[next.v] = cost;
                    pq.add(new Node(next.v, next.w));
                }
            }
        }
        System.out.println(distances[N - 1]);
    }

    private static class Node {
        int v;
        int w;

        public Node(final int v, final int w) {
            this.v = v;
            this.w = w;
        }
    }

}
