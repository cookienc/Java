package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2578 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[5][5];
        final Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                final int value = Integer.parseInt(st.nextToken());
                bingo[i][j] = value;
                map.put(value, new int[]{i, j});
            }
        }

        int cnt = 0;
        boolean isEnd = false;
        for (int i = 0; i < 5; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cnt++;
                final int flag = Integer.parseInt(st.nextToken());
                final int[] position = map.get(flag);
                bingo[position[0]][position[1]] = -1;

                if (checkBingo(bingo)) {
                    isEnd = true;
                    break;
                }
            }
            if (isEnd) {
                break;
            }
        }

        System.out.println(cnt);

    }

    private static boolean checkBingo(final int[][] bingo) {
        int bingoCnt = 0;

        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                bingoCnt++;
            }
        }

        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                bingoCnt++;
            }
        }

        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != -1) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            bingoCnt++;
        }

        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[4 - i][i] != -1) {
                isBingo = false;
                break;
            }
        }

        if (isBingo) {
            bingoCnt++;
        }

        return bingoCnt >= 3;
    }
}
