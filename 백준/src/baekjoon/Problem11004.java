package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11004 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int num = Integer.parseInt(stringTokenizer.nextToken());
        int index = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = new int[num];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(array);

        System.out.println(array[index - 1]);
    }
}
