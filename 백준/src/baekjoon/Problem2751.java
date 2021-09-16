package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2751 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000000) {
            throw new Exception("오류");
        }

        int[] array = new int[num];


        for (int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(array);

        for (int i : array) {
            stringBuilder.append(i).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
