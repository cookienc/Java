package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        dp[n] = 1;

        queue.add(n);

        int count = 0;

        while(dp[1] == 0) {
            count++;

            int size = queue.size();

            for(int i = 0; i < size; i++) {

                int num = queue.poll();

                if(num % 3 == 0 && dp[num / 3] == 0) {
                    dp[num / 3] = count;
                    queue.add(num / 3);
                }

                if(num % 2 == 0 && dp[num / 2] == 0) {
                    dp[num / 2] = count;
                    queue.add(num / 2);
                }

                if(dp[num - 1] == 0) {
                    dp[num - 1] = count;
                    queue.add(num - 1);
                }

            }
        }
        System.out.println(count);
    }
}