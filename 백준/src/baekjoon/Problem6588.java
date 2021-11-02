package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6588 {

    private static boolean[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        while (n != 0) {

            findPrime(n);

            boolean exit = false;

            for (int i = prime.length - 2; i > prime.length / 2; i--) {
                for (int j = 2; j <= i; j++) {
                    if ((!prime[i]) && (!prime[j]) && (n == (i + j))) {
                        stringBuilder.append(n)
                                .append(" = ")
                                .append(j)
                                .append(" + ")
                                .append(i)
                                .append("\n");
                        exit = true;
                        break;
                    }
                }
                if (exit) {
                    break;
                }

                if (i == prime.length + 1) {
                    stringBuilder.append("Goldbach's conjecture is wrong.")
                            .append("\n");
                }
            }
            n = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(stringBuilder);
    }

    public static void findPrime(int n) {

        prime = new boolean[n + 1];

        if (n < 2) {
            return;
        }

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}