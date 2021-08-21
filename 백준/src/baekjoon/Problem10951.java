package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String str;

        while((str = bufferedReader.readLine()) != null) {

            int a = str.charAt(0) - 48;
            int b = str.charAt(2) - 48;

            stringBuilder.append(a + b).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
