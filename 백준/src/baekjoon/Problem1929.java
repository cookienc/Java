package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1929 {

    private static boolean[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        StringBuilder stringBuilder = new StringBuilder();

        findPrime(m, n);

        for (int i = m; i < prime.length; i++) {
            if (!prime[i]) {
                stringBuilder.append(i)
                .append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
    public static void findPrime(int m, int n) {

        prime = new boolean[n + 1];

        if(n < 2) {
            return;
        }

        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {

            if(prime[i]) {
                continue;
            }

            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
