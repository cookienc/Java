package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2742 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num > 100000) {
            throw new Exception("범위가 틀렸습니다.");
        }

        for (int i = num; i > 0; i--) {
            stringBuilder.append(i).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }
}
