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

public class Problem1446 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());

        final List<List<Node>> graphes = new ArrayList<>();
        for (int u = 0; u <= D; u++) {
            final List<Node> nodes = new ArrayList<>();
            for (int v = u + 1; v <= D; v++) {
                nodes.add(new Node(v, v - u));
            }
            graphes.add(nodes);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            final int w = Integer.parseInt(st.nextToken());
            if (u > D || v > D) {
                continue;
            }
            graphes.get(u).add(new Node(v, w));
        }

        int[] distance = new int[10001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        final PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.w));
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            final Node cur = pq.poll();
            final int cv = cur.v;
            final int cw = cur.w;

            if (distance[cv] < cw) {
                continue;
            }

            final List<Node> nextNodes = graphes.get(cv);
            for (int i = 0; i < nextNodes.size(); i++) {
                final Node next = nextNodes.get(i);
                final int cost = distance[cv] + next.w;

                if (cost < distance[next.v]) {
                    distance[next.v] = cost;
                    pq.add(new Node(next.v, next.w));
                }
            }
        }

        System.out.println(distance[D]);
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
