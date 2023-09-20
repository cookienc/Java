package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem26215 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int[] house = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < house.length; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);

        int cnt = 0;
        while (house[N - 1] != 0) {
            cnt++;
            house[N - 1]--;
            if (N - 2 >= 0 && house[N - 2] != 0) {
                house[N - 2]--;
            }
            Arrays.sort(house);
        }

        System.out.println(cnt > 1440 ? -1 : cnt);
    }
}
