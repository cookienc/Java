package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem27964 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final Set<String> toppings = new HashSet<>();
        for (int i = 0; i < N; i++) {
            toppings.add(st.nextToken());
        }

        int cnt = 0;
        for (final String topping : toppings) {
            if (topping.endsWith("Cheese")) {
                cnt++;
            }
        }

        if (cnt >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
