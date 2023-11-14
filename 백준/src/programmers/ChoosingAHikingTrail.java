package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ChoosingAHikingTrail {

    private static int peak = Integer.MAX_VALUE;
    private static int intensity = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 7;
        int[][] paths = new int[][]{
                {1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}
        };
        int[] gates = new int[]{3,7};
        int[] summits = new int[]{1,5};
        final int[] solution = Solution.solution(n, paths, gates, summits);
        System.out.println(solution[0] + " " + solution[1]);
    }

    /**
     * 양방향
     * 휴식 없이 가장 긴 시간 이동 -> intensity
     * 시작 -> 산봉우리 -> 시작 (시작은 같은 위치, 다른 입구 x)
     */
    static class Solution {
        public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

            final List<List<Node>> graphes = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graphes.add(new ArrayList<>());
            }

            for (final int[] path : paths) {
                final int u = path[0];
                final int v = path[1];
                final int w = path[2];
                graphes.get(u).add(new Node(v, w));
                graphes.get(v).add(new Node(u, w));
            }

            final Set<Integer> totalGates = new HashSet<>();
            for (final int gate : gates) {
                totalGates.add(gate);
            }
            final Set<Integer> totalSummits = new HashSet<>();
            for (final int summit : summits) {
                totalSummits.add(summit);
            }

            for (final int gate : gates) {
                final int[] toSummits = toSummitIntensity(n, gate, graphes, totalGates, totalSummits);
                for (final int summit : summits) {
                    final int tmpInt = toSummits[summit];

                    if (intensity > tmpInt) {
                        intensity = tmpInt;
                        peak = summit;
                        continue;
                    }

                    if (intensity == tmpInt) {
                        intensity = tmpInt;
                        peak = Math.min(summit, peak);
                    }
                }
            }

            return new int[]{peak, intensity};
        }

        private static int[] toSummitIntensity(final int n, final int start, final List<List<Node>> graphes, final Set<Integer> totalGates, final Set<Integer> totalSummits) {
            final PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.w));
            pq.add(new Node(start, 0));

            int[] distanace = new int[n + 1];
            Arrays.fill(distanace, Integer.MAX_VALUE);
            distanace[start] = 0;
            while (!pq.isEmpty()) {
                final Node cur = pq.poll();
                final int cv = cur.v;
                final int cw = cur.w;

                if (distanace[cv] < cw) {
                    continue;
                }

                if (intensity != Integer.MAX_VALUE && intensity < distanace[cv]) {
                    continue;
                }

                final List<Node> nodes = graphes.get(cv);
                final int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    final Node next = nodes.get(i);
                    if (next.v != start && totalGates.contains(next.v)) {
                        continue;
                    }
                    int cost;
                    if (distanace[cv] == 0) {
                        cost = next.w;
                    } else {
                        cost = Math.max(distanace[cv], next.w);
                    }

                    if (cost < distanace[next.v]) {
                        distanace[next.v] = cost;
                        if (totalSummits.contains(next.v)) {
                            continue;
                        }
                        pq.add(next);
                    }
                }
            }
            return distanace;
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
}
