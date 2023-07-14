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
        int[] doll = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(doll);
        int[] answer = new int[N];
        boolean[] isSaved = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isSaved[i] && (answer[j] == 0 || answer[j] < doll[i])) {
                    answer[j] = doll[i];
                    isSaved[i] = true;
                }
            }
        }

        int cnt = 0;
        for (int i : answer) {
            if (i == 0) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
