package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11719 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String str = "";

        while (true) {
            str = bufferedReader.readLine();
            if (str == null) {
                break;
            } else {
                stringBuilder.append(str).append(NEW_LINE);
            }
        }
        System.out.println(stringBuilder);
    }
}
