package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num == 0) {
            System.out.println(num);
            System.exit(0);
        }

        String answer = "";

        while (num != 0) {
            if (num % -2 == -1) {
                answer = 1 + answer;
                num = (num / -2) + 1;
            } else {
                answer = (num % -2) + answer;
                num /= -2;
            }
        }

        System.out.println(answer);
    }
}
