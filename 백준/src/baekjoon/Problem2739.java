package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2739 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 9) {
            throw new Exception("범위가 틀렸습니다.");
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }
}
