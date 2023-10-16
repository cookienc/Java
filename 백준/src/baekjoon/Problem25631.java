package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem25631 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] dolls = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dolls);
        int[] answer = new int[N];
        boolean[] isSaved = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (isSaved[i]) {
                continue;
            }
            answer[i] = dolls[i];
            isSaved[i] = true;
            for (int j = i + 1; j < N; j++) {
                if (isSaved[j]) {
                    continue;
                }

                if (answer[i] < dolls[j]) {
                    answer[i] = dolls[j];
                    isSaved[j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i : answer) {
            if (i == 0) {
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
