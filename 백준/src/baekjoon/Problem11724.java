package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11724 {

    private static List<Integer>[] list;
    private static boolean[] isVisited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        list = new ArrayList[n + 1];

        initializeList(n);

        isVisited = new boolean[n + 1];

        connectDot(bufferedReader, m);

        sortList(n);

        findConnectedDot(n);

        System.out.println(count);
    }

    private static void initializeList(int n) {
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }
    }

    private static void findConnectedDot(int n) {
        for (int i = 1; i < (n + 1); i++) {
            if (!isVisited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private static void dfs(int i) {
        if (isVisited[i]) {
            return;
        }

        isVisited[i] = true;

        Stack<Integer> stack = new Stack<>();

        for (int n : list[i]) {
            if (!isVisited[n]) {
                dfs(n);
            }
        }
    }

    private static void sortList(int n) {
        for (int i = 1; i < (n + 1); i++) {
            Collections.sort(list[i]);
        }
    }

    private static void connectDot(BufferedReader bufferedReader, int m) throws IOException {

        StringTokenizer stringTokenizer;

        for (int i = 1; i < (m + 1); i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int dotA = Integer.parseInt(stringTokenizer.nextToken());
            int dotB = Integer.parseInt(stringTokenizer.nextToken());

            list[dotA].add(dotB);
            list[dotB].add(dotA);
        }
    }
}
