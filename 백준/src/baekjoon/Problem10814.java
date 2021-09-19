package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10814 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100000) {
            throw new Exception("오류");
        }

        String[][] input = new String[num][2];

        for (int i = 0; i < num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            input[i][0] = stringTokenizer.nextToken();
            input[i][1] = stringTokenizer.nextToken();
        }

        Arrays.sort(input, (a, b) -> {
            if (Integer.parseInt(a[0]) == Integer.parseInt(b[0])) {
                return 0;
            } else {
                return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
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
