package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1934 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            int bigNum = Math.max(a, b);
            int smallNum = Math.min(a, b);

            int tmp = 0;

            while(smallNum != 0) {
                tmp = bigNum % smallNum;
                bigNum = smallNum;
                smallNum = tmp;
            }

            stringBuilder.append(a * b / bigNum).append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }
}
