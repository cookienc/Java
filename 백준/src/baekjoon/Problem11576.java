package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        List<Integer> list = new ArrayList<>();
                
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        aToDecimal(a, list);
        for (int i = 0; i < list.size(); i++) {
            decimalToB(b, list.get(0));
        }

        for (Integer integer : list) {
            System.out.print(list + " ");
        }
    }

    private static Integer decimalToB(int b, Integer number) {
        String str = " ";

        while (number != 0) {
            int temp = number % b;
            number /= b;
            str = temp + str;
        }

        return Integer.parseInt(str);
    }

    private static void aToDecimal(int a, List<Integer> list) {
        for (int i = list.size() - 1; i >= 0 ; i--) {
            list.add(i, list.get(i) * (int)Math.pow(a, i));
        }
    }
}
