package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        char[] word = bufferedReader.readLine().toCharArray();

        String[] array = new String[word.length];

        for (int i = 0; i < word.length; i++) {
            array[i] = String.valueOf(Arrays.copyOfRange(word, i, word.length));
        }

        Arrays.sort(array);

        for (String s : array) {
            stringBuilder.append(s).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
