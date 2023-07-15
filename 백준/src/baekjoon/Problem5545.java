package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5545 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        final int C = Integer.parseInt(br.readLine());

        int[] toppings = new int[N];
        for (int i = 0; i < N; i++) {
            toppings[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(toppings);
        int calories = C;
        int price = A;
        int answer = calories / price;
        for (int i = toppings.length - 1; i >= 0; i--) {
            calories += toppings[i];
            price += B;
            answer = Math.max(answer, calories / price);
        }

        System.out.println(answer);
    }
}
