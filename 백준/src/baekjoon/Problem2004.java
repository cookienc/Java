package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2004 {

        private static int fiveUp = 0;
        private static int fiveDown = 0;
        private static int countFive = 0;
        private static int twoUp = 0;
        private static int twoDown = 0;
        private static int countTwo = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        findFiveUp(n);
        findFiveDown(n - m);
        findFiveDown(m);

        findTwoUp(n);
        findTwoDown(n - m);
        findTwoDown(m);

        countFive = fiveUp - fiveDown;
        countTwo = twoUp - twoDown;

        System.out.println(Math.min(countFive, countTwo));
    }

    private static void findFiveDown(int n) {
        while (n >= 5) {
            fiveDown += n / 5;
            n /= 5;
        }
    }

    private static void findFiveUp(int n) {
        while (n >= 5) {
            fiveUp += n / 5;
            n /= 5;
        }
    }

    private static void findTwoDown(int n) {
        while (n >= 2) {
            twoDown += n / 2;
            n /= 2;
        }
    }

    private static void findTwoUp(int n) {
        while (n >= 2) {
            twoUp += n / 2;
            n /= 2;
        }
    }
}
