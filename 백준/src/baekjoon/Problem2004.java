package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2004 {

    private static int five = 0;
    private static int two = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int countFive = findFive(n) - findFive(n - m) - findFive(m);
        int countTwo = findTwo(n) - findTwo(n - m) - findTwo(m);

        System.out.println(Math.min(countFive, countTwo));
    }

    private static int findFive(int n) {

        five = 0;

        while (n >= 5) {
            five += n / 5;
            n /= 5;
        }

        return five;
    }

    private static int findTwo(int n) {

        two = 0;

        while (n >= 2) {
            two += n / 2;
            n /= 2;
        }

        return two;
    }
}