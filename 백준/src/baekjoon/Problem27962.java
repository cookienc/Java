package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem27962 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final String word = br.readLine().replaceAll(" ", "");

        N = word.length();
        for (int s = 1; s <= N; s++) {
            final String cur = word.substring(0, s);
            final String target = word.substring(N - s, N);

            if (isVitamin(cur, target)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    private static boolean isVitamin(final String cur, final String target) {
        int different = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != target.charAt(i)) {
                different++;
            }
        }

        return different == 1;
    }
}
