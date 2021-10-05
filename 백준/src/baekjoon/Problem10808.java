package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        int[] array = new int[26];

        for (int i = 0; i < string.length(); i++) {
            array[string.charAt(i) - 'a']++;
        }

        for (int i : array) {
            stringBuilder.append(i).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
