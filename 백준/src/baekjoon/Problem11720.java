package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11720 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        String str = "";

        try {

            int num = Integer.parseInt(bufferedReader.readLine());
            str = bufferedReader.readLine();

            for (int i = 0; i < num; i++) {
                sum += str.charAt(i) - '0';
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}
