package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(stringTokenizer.nextToken());
        int space = Integer.parseInt(stringTokenizer.nextToken());

        int count = 1;

        List list = new LinkedList<Integer>();
        List answer = new LinkedList<Integer>();

        initialize(num, list);

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++, count++) {
                if (count == space) {
                    answer.add(list.get(i));
                    list.remove(i);

                    if (i == list.size()) {
                        count = 0;
                    } else {
                        count = 1;
                    }
                }
            }
        }
        stringBuilder.append("<");
        for (int i = 0; i < answer.size() - 1; i++) {
            stringBuilder.append(answer.get(i))
                    .append(", ");
        }
        stringBuilder.append(answer.get(answer.size() - 1))
                .append(">");

        System.out.println(stringBuilder);

    }

    private static void initialize(int num, List list) {
        for (int i = 0; i < num; i++) {
            list.add(i, i + 1);
        }
    }
}
