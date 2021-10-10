package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        String word1 = stringTokenizer.nextToken() + stringTokenizer.nextToken();
        String word2 = stringTokenizer.nextToken() + stringTokenizer.nextToken();

        long ans = Long.parseLong(word1) + Long.parseLong(word2);
        System.out.println(ans);
    }
}
