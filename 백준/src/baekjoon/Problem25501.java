package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25501 {

    private static int cnt;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            cnt = 0;
            final String s = br.readLine();
            int isPalindrom = isPalindrom(s, 0, s.length() - 1);
            System.out.println(isPalindrom + " " + cnt);
        }
    }

    private static int isPalindrom(final String s, final int start, final int end) {
        cnt++;

        if (start >= end) {
            return 1;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return 0;
        }

        return isPalindrom(s, start + 1, end - 1);
    }
}
