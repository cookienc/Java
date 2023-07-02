package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem25602 {

    private static int N = 0;
    private static int K = 0;
    private static int answer = 0;
    private static int[][] M;
    private static int[][] R;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] foods = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }

        R = new int[K][N];
        for (int date = 0; date < K; date++) {
            st = new StringTokenizer(br.readLine());
            for (int food = 0; food < N; food++) {
                R[date][food] = Integer.parseInt(st.nextToken());
            }
        }

        M = new int[K][N];
        for (int date = 0; date < K; date++) {
            st = new StringTokenizer(br.readLine());
            for (int food = 0; food < N; food++) {
                M[date][food] = Integer.parseInt(st.nextToken());
            }
        }

        findMax(0, 0, foods);
        System.out.println(answer);
    }

    private static void findMax(int day, int sum, int[] foods) {
        if (day == K) {
            answer = Math.max(sum, answer);
            return;
        }

        final int[] newFoods = Arrays.copyOf(foods, foods.length);
        for (int i = 0; i < N; i++) {
            if (newFoods[i] <= 0) {
                continue;
            }
            newFoods[i]--;
            sum += R[day][i];

            for (int j = 0; j < N; j++) {
                if (newFoods[j] <= 0) {
                    continue;
                }
                newFoods[j]--;
                sum += M[day][j];
                findMax(day + 1, sum, newFoods);
                newFoods[j]++;
                sum -= M[day][j];
            }
            newFoods[i]++;
            sum -= R[day][i];
        }
    }
}
