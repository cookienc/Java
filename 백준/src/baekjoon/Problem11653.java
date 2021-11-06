package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 2; i <= num; i++){
            if (num % i == 0) {
                System.out.println(i);
                num = num / i;
                i -= 1;
            }

            if (num == 1) {
                return;
            }
        }

    }
}
