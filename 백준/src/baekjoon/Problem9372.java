package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9372
 */
public class Problem9372 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                parent[i] = i;
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                final int u = Integer.parseInt(st.nextToken());
                final int v = Integer.parseInt(st.nextToken());

                pq.offer(new Edge(u, v));
                pq.offer(new Edge(v, u));
            }

            int cnt = 0;
            while (!pq.isEmpty()) {
                final Edge cur = pq.poll();
                if (!findParent(cur.u, cur.v)) {
                    cnt++;
                    unionParent(cur.u, cur.v);
                }
            }

            System.out.println(cnt);
        }

    }

    private static boolean findParent(int u, int v) {
        u = getParent(u);
        v = getParent(v);

        return u == v;
    }

    private static int getParent(final int u) {
        if (parent[u] == u) {
            return u;
        }

        return parent[u] = getParent(parent[u]);
    }

    private static void unionParent(int u, int v) {
        u = getParent(u);
        v = getParent(v);

        if (u < v) {
            parent[v] = u;
            return;
        }

        parent[u] = v;
    }

    private static class Edge {
        int u;
        int v;
        int weight;

        public Edge(final int u, final int v) {
            this.u = u;
            this.v = v;
        }
    }
}
