package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1260 {

    private static List<Integer>[] map;
    private static List<Integer> dfsList;
    private static boolean[] isVisited;
    private static int n;
    private static int m;
    private static int v;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        v = Integer.parseInt(stringTokenizer.nextToken());

        map = new ArrayList[n + 1];
        dfsList = new ArrayList<>();
        isVisited = new boolean[n + 1];


        initializeList(bufferedReader);

        sortList();

        dfs(v);

        for (Integer integer : dfsList) {
            System.out.print(integer + " ");
        }


    }

    private static void dfs(int num) {

        if (isVisited[num]) {
            return;
        }

        isVisited[num] = true;
        dfsList.add(num);

        for (int y : map[num]) {
            if (!isVisited[y]) {
                dfs(y);
            }
        }
    }

    private static void sortList() {
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(map[i]);
        }
    }
//test
    private static void initializeList(BufferedReader bufferedReader) throws IOException {
        StringTokenizer stringTokenizer;
        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < m + 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            map[a].add(b);
            map[b].add(a);
        }
    }
}