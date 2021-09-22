package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem11652 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100000) {
            throw new Exception("오류");
        }

        long[] array = new long[num];

        for (int i = 0; i < num; i++) {
            array[i] = Long.parseLong(bufferedReader.readLine());
        }

        Arrays.sort(array);

        long maxValue = array[0];
        int index = 1;
        int count = 1;

        for (int i = 1; i < num; i++) {
            if (array[i] == array[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > index) {
                index = count;
                maxValue = array[i];
            }
        }

        System.out.println(maxValue);

    }
}
