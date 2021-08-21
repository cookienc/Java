package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String str;

        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(a + b).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
