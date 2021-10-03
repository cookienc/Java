package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem10845 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        Queue<Integer> queue = new LinkedList<Integer>();

        int back = -1;

        for(int i = 0 ; i < num ; i ++)
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String type = stringTokenizer.nextToken();

            switch(type) {

                case "push":
                    back = Integer.parseInt(stringTokenizer.nextToken());
                    queue.offer(back);
                    break;

                case "pop":
                    if(queue.isEmpty()) {
                        stringBuilder.append("-1").append("\n");
                        break;
                    }
                    stringBuilder.append(queue.poll()).append("\n");
                    break;

                case "size":
                    stringBuilder.append(queue.size()).append("\n");
                    break;

                case "empty":
                    stringBuilder.append(queue.isEmpty() ? 1: 0).append("\n");
                    break;

                case "front":
                    stringBuilder.append(queue.isEmpty() ? -1: queue.peek()).append("\n");
                    break;

                case "back":
                    stringBuilder.append(queue.isEmpty() ? -1: back).append("\n");
                    break;
            }
        }
        System.out.print(stringBuilder);
    }
}
