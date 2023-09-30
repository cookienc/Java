package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem12101 {

    private static final Set<String> answer = new HashSet<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            dfs(i, String.valueOf(i));
        }

        if (answer.size() < K) {
            System.out.println(-1);
            return;
        }

        final List<String> collect = answer.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect.get(K - 1));
    }

    private static void dfs(final int sum, final String value) {
        if (sum == N) {
            answer.add(value);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum + i > N) {
                continue;
            }

            dfs(sum + i, value + "+" +i);
        }
    }
}
