package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1850 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());

        long bigNum = Math.max(a, b);
        long smallNum = Math.min(a, b);

        long tmp = 0;

        while(smallNum != 0) {
            tmp = bigNum % smallNum;
            bigNum = smallNum;
            smallNum = tmp;
        }

        for (int i = 0; i < bigNum; i++) {
            stringBuilder.append("1");
        }

        System.out.println(stringBuilder);
    }
}
