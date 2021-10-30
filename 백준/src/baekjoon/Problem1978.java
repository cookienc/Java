package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bufferedReader.readLine());

        int count = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 0; i < number; i++) {
            int a = Integer.parseInt(stringTokenizer.nextToken());

            if (a == 1) {
                continue;
            }

            int temp = 0;

            for (int j = 2; j < a; j++) {
                if (a % j != 0) {
                    temp++;
                }
            }

            if (temp == (a - 2)) {
                count++;
            }

        }

        System.out.println(count);
    }
}
