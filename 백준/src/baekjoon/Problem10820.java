package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string = "";
        StringBuilder stringBuilder = new StringBuilder();

        while ((string = bufferedReader.readLine()) != null) {

            int[] array = new int[4];

            for (int i = 0; i < string.length(); i++) {
                char type = string.charAt(i);
                if (type == ' ') {
                    array[3]++;
                    continue;
                }

                if (type >= 'a' && type <= 'z') {
                    array[0]++;
                    continue;
                }

                if (type >= 'A' && type <= 'Z') {
                    array[1]++;
                    continue;
                }

                if (type >= '0' && type <= '9') {
                    array[2]++;
                    continue;
                }

            }

            for (int i : array) {
                stringBuilder.append(i).append(" ");
            }

            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}
