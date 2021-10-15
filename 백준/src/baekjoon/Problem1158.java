package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(stringTokenizer.nextToken());
        int space = Integer.parseInt(stringTokenizer.nextToken());

        int count = 1;

        Queue<Integer> queue = new LinkedList<Integer>();

        initialize(num, queue);

        stringBuilder.append("<");

        while (queue.size() != 1) {
            for (int i = 0; i < space - 1; i++) {
                queue.offer(queue.poll());
            }

            stringBuilder.append(queue.poll() + ", ");
        }

        stringBuilder.append(queue.poll() + ">");

        System.out.println(stringBuilder);

    }

    private static void initialize(int num, Queue queue) {
        for (int i = 0; i < num; i++) {
            queue.offer(i + 1);
        }
    }
}
