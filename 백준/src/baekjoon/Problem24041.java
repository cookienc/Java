package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/24041
 */
public class Problem24041 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int G = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        final List<Food> foods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int s = Integer.parseInt(st.nextToken());
            final int l = Integer.parseInt(st.nextToken());
            final int o = Integer.parseInt(st.nextToken());

            foods.add(new Food(s, l, o));
        }

        foods.sort((f1, f2) -> {
            if (f1.s == f2.s && f1.o == f2.o) {
                return f2.l - f1.l;
            }

            if (f1.o == f2.o) {
                return f2.s - f1.s;
            }

            return f2.o - f1.o;
        });

        long low = 0;
        long high = 2_000_000_000;
        while (low <= high) {
            long day = low + (high - low) / 2;

            final long calculate = calculate(foods, day, K);
            if (calculate > G) {
                high = day - 1;
                continue;
            }

            if (calculate == G) {
                high = day;
                break;
            }

            low = day + 1;
        }

        System.out.println(high);
    }

    private static long calculate(final List<Food> foods, final long day, int K) {
        final PriorityQueue<Long> viruses = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (final Food food : foods) {
            final long virus = food.s * Math.max(1, day - food.l);
            if (food.o == 1) {
                viruses.add(virus);
            }
            sum += virus;
        }

        while (K-- > 0 && !viruses.isEmpty()) {
            sum -= viruses.poll();
        }

        return sum;
    }

    private static class Food {
        int s;
        int l;
        int o;

        public Food(final int s, final int l, final int o) {
            this.s = s;
            this.l = l;
            this.o = o;
        }
    }
}
