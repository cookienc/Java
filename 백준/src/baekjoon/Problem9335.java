package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9335 {

    private static int[][] friends;
    private static int N;
    private static int min;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            friends = new int[N + 1][N + 1];
            for (int i = 0; i < N; i++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                final int size = Integer.parseInt(st.nextToken());

                for (int j = 0; j < size; j++) {
                    friends[i + 1][Integer.parseInt(st.nextToken())]++;
                }
            }

            for (int i = 1; i <= N; i++) {
                dfs(i, 1, 0, 0);
            }
            System.out.println(min);
        }
    }

    private static void dfs(final int currentPeople, int count, int checked, int isFriend) {
        if (currentPeople > N) {
            return;
        }

        checked |= (1 << currentPeople);
        isFriend = checkFriend(currentPeople, isFriend);

        if (Integer.bitCount(isFriend) == N) {
            min = Math.min(min, count);
            return;
        }

        if (Integer.bitCount(checked) == N) {
            return;
        }

        for (int i = currentPeople + 1; i <= N; i++) {
            if ((checked & (1 << i)) != 0) {
                continue;
            }

            dfs(i, count + 1, checked, isFriend);
        }
    }

    private static int checkFriend(final int people, int isFriend) {
        isFriend |= (1 << people);

        for (int i = 1; i <= N; i++) {
            if (friends[people][i] == 1) {
                isFriend |= (1 << i);
            }
        }

        return isFriend;
    }
}
