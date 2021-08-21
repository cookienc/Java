package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String str;

        while(!(str = bufferedReader.readLine()).equals("0 0")) {

            int a = str.charAt(0) - 48;
            int b = str.charAt(2) - 48;

            stringBuilder.append(a + b).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
