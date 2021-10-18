package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> list = new ArrayList<>();
        int smallNum = 0;
        int bigNum = 0;

        if (a > b) {
            smallNum = b;
            bigNum = a;
        } else {
            smallNum = a;
            bigNum = b;
        }

        for (int i = smallNum; i >= 2; i--) {
            if ((bigNum % i == 0) && (smallNum % i == 0)) {
                bigNum /= i;
                smallNum /= i;
                list.add(i);
            }
        }

        int numA = 1;
        int numB = 1;

        for (int i = 0; i < list.size(); i++) {
            numA *= list.get(i);
        }

        numB = numA * smallNum * bigNum;

        System.out.println(numA);
        System.out.println(numB);
    }
}
