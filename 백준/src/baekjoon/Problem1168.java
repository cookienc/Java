package baekjoon;

import java.io.*;
import java.util.*;

public class Problem1168 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(stringTokenizer.nextToken());
        int space = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> list = new ArrayList<Integer>();

        initialize(num, list);

        stringBuilder.append("<");

        int index = 0;

        for (int i = 0; i < num - 1; i++) {

            index += space - 1;

            if (index >= list.size()) {
                index %= list.size();
            }

            stringBuilder.append(list.remove(index))
                    .append(", ");
        }

        stringBuilder.append(list.get(0) + ">");

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
    }

    private static void initialize(int num, List list) {
        for (int i = 0; i < num; i++) {
            list.add(i + 1);
        }
    }
}
