package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11651 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 0 || num > 100000) {
            throw new Exception("오류");
        }

        int[][] input = new int[num][2];

        for (int i = 0; i < num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            input[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            input[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(input, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int i = 0; i < num; i++) {
            stringBuilder.append(input[i][0])
                    .append(" ")
                    .append(input[i][1])
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

}
