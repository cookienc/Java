package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6588 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        boolean[] isNotPrime = new boolean[1000001];

        for (int i = 2; i <= 1000000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while(true) {
            int number = Integer.parseInt(bufferedReader.readLine());
            boolean isExists = false;

            if(number == 0) {
                System.out.println(stringBuilder);

                return;
            }

            for (int i = 3; i <= number; i += 2) {
                if (!isNotPrime[i] && !isNotPrime[number - i]) {
                    stringBuilder.append(number + " = " + i + " + " + (number - i)).append("\n");
                    isExists = true;
                    break;
                }
            }

            if (!isExists) {
                stringBuilder.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
    }
}
