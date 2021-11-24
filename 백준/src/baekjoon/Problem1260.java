package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1260 {

    static int N;
    static int M;
    static int V;

    static List<Integer>[] line;

    static int index = 0;
    static int[] visited = new int[1001];
    static boolean isEnd = false;

    public static void main(String[] args) throws Exception
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input);
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        V = Integer.parseInt(stringTokenizer.nextToken());

        line = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
        {
            line[i] = new ArrayList<Integer>();
        }

        String[] inputs = new String[2];

        for (int i = 1; i <= M; i++)
        {
            input = bufferedReader.readLine();
            inputs = input.split(" ");
            line[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
            line[Integer.parseInt(inputs[1])].add(Integer.parseInt(inputs[0]));
        }

        for (int i = 1; i <= N; i++)
        {
            Collections.sort(line[i]);
        }

        // DFS
        visited[V] = 1;

        System.out.print(V + " ");

        index++;

        dfs(V);

        for (int i = 1; i <= N; i++)
        {
            visited[i] = 0;
        }

        System.out.println();

        // BFS
        bfs(V);
        System.out.println();
    }

    private static void bfs(int node)
    {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        visited[node] = 1;
        index = 1;

        while (queue.isEmpty() == false)
        {
            node = queue.remove();
            System.out.print(node + " ");
            for (int next : line[node])
            {
                if (visited[next] == 0)
                {
                    index++;
                    visited[next] = 1;
                    queue.add(next);
                }
            }
        }
    }

    private static void dfs(int node)
    {
        for (int next : line[node])
        {
            if (visited[next] == 0)
            {
                System.out.print(next + " ");
                index++;
                visited[next] = 1;
                dfs(next);
            }
        }
    }
}
