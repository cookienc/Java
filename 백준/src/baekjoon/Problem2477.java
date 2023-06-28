package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2477 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(br.readLine());

        int[] directions = new int[5];
        int[] d = new int[6];
        int[] l = new int[6];
        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            final int direction = Integer.parseInt(st.nextToken());
            directions[direction]++;
            d[i] = direction;
            l[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        List<Integer> minus = new ArrayList<>();
        for (int i = 1; i < directions.length; i++) {
            if (directions[i] == 1) {
                int value = 0;
                for (int j = 0; j < 6; j++) {
                    if (d[j] == i) {
                        minus.add(j);
                        value = l[j];
                        break;
                    }
                }

                if (sum == 0) {
                    sum = value;
                } else {
                    sum *= value;
                }
            }
        }

        int empty = l[(minus.get(0) + 3) % 6] * l[(minus.get(1) + 3) % 6];

        System.out.println((sum - empty) * K);
    }
}
