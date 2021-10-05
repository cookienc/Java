package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        int[] array = new int[26];

        Arrays.fill(array, -1);

        for (int i = 0; i < string.length(); i++) {
            int index = string.charAt(i) - 'a';
            if (array[index] != -1) {
                continue;
            }
            array[index] = i;
        }

        for (int i : array) {
            stringBuilder.append(i).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
