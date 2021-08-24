package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10818 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(bufferedReader.readLine());

        int[] tmp = new int[num];

        if (num < 1 || num > 1000000) {
            throw new Exception("오류");
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 0; i < num; i++) {
            tmp[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(tmp);

        stringBuilder.append(tmp[0]).append(" ").append(tmp[tmp.length - 1]);

        System.out.println(stringBuilder);
    }
}
