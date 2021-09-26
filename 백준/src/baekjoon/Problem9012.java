package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(bufferedReader.readLine());

        List<String> str = new ArrayList<>();

        initialize(bufferedReader, num, str);

        findVps(stringBuilder, num, str);

        System.out.println(stringBuilder);
    }

    private static void findVps(StringBuilder stringBuilder, int num, List<String> str) {
        for (int i = 0; i < num; i++) {
            char[] c = str.get(i).toCharArray();
            int left = 0;
            int right = 0;

            if (c[0] == ')' || c[c.length - 1] == '(') {
                stringBuilder.append("NO").append("\n");
                continue;
            }

            for (char ary : c) {
                if (ary == '(') {
                    left++;
                } else {
                    right++;
                }

                if (left < right) {
                    break;
                }
            }

            if (left != right) {
                stringBuilder.append("NO").append("\n");
            } else {
                stringBuilder.append("YES").append("\n");
            }

        }
    }

    private static void initialize(BufferedReader bufferedReader, int num, List<String> str) throws IOException {
        for (int i = 0; i < num; i++) {
            str.add(bufferedReader.readLine());
        }
    }
}
