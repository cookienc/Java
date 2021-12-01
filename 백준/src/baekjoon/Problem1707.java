package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1707 {

    private static List<Integer>[] lists;
    private static boolean[] isVisited;
    private static boolean[] color;
    private static boolean checkBipartite;

    private static boolean RED = true;
    private static boolean BLUE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        int k = Integer.parseInt(bufferedReader.readLine());

        while (k-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());

            lists = new ArrayList[v + 1];
            isVisited = new boolean[v + 1];
            color = new boolean[v + 1];
            checkBipartite = true;

            for (int j = 1; j < v +  1; j++) {
                lists[j] = new ArrayList<>();
            }

            for (int j = 1; j < e + 1; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int dotA = Integer.parseInt(stringTokenizer.nextToken());
                int dotB = Integer.parseInt(stringTokenizer.nextToken());

                lists[dotA].add(dotB);
                lists[dotB].add(dotA);
            }

            for (int j = 1; j < v + 1; j++) {
                if (!checkBipartite) {
                    break;
                }

                if (!isVisited[j]) {
                    bfs(j);
                }
            }

            if (checkBipartite) {
                stringBuilder.append("YES").append("\n");
            } else {
                stringBuilder.append("NO").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        boolean setColor = RED;

        isVisited[num] = true;
        color[num] = RED;
        queue.add(num);

        while (!queue.isEmpty() && checkBipartite) {

            int x = queue.poll();
            setColor = !color[x];

            for (int i : lists[x]) {
                if (!isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    color[i] = setColor;
                }

                if (color[x] == color[i]) {
                    checkBipartite = false;
                    return;
                }
            }
        }
    }
}
