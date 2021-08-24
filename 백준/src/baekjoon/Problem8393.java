package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem8393 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());
        int sum = 0;

        if (num < 1 || num > 10000) {
            throw new Exception("범위 오류");
        }

        for (int i = 1; i <= num; i++) {
            sum += i;
        }

        System.out.println(sum);

    }
}
