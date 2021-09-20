package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10825 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100000) {
            throw new Exception("오류");
        }

        String[][] input = new String[num][4];

        for (int i = 0; i < num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            input[i][0] = stringTokenizer.nextToken();
            input[i][1] = stringTokenizer.nextToken();
            input[i][2] = stringTokenizer.nextToken();
            input[i][3] = stringTokenizer.nextToken();
        }

        Arrays.sort(input, (a, b) -> {
            if (Integer.parseInt(a[1]) == Integer.parseInt(b[1])) {
                if (Integer.parseInt(a[2]) == Integer.parseInt(b[2])) {
                    if(Integer.parseInt(a[3]) == Integer.parseInt(b[3])) {
                        return a[0].compareTo(b[0]);
                    } else {
                        return Integer.parseInt(b[3]) - Integer.parseInt(a[3]);
                    }
                } else {
                    return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
                }
            } else {
                return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
            }
        });

        for (int i = 0; i < num; i++) {
            stringBuilder.append(input[i][0])
                    .append(" ")
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

}
