package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        List<Long> list = new ArrayList<>();

        int num = Integer.parseInt(bufferedReader.readLine());
        long sum = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int size = Integer.parseInt(stringTokenizer.nextToken());

            list.clear();

            for (int j = 0; j < size; j++) {
                list.add(Long.parseLong(stringTokenizer.nextToken()));
            }

            sum = 0;

            sum = getSum(list, sum, size);

            stringBuilder.append(sum)
                    .append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static long getSum(List<Long> list, long sum, int size) {
        for (int j = 0; j < size; j++) {
            for (int k = j + 1; k < size; k++) {
                sum += findGCD(list.get(j), list.get(k));
            }
        }
        return sum;
    }

    public static long findGCD(long a, long b) {
        long bigNum = Math.max(a, b);
        long smallNum = Math.min(a, b);

        long tmp = 0;

        while (smallNum != 0) {
            tmp = bigNum % smallNum;
            bigNum = smallNum;
            smallNum = tmp;
        }
        return bigNum;
    }
}