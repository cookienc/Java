package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/21921
 */
public class Problem21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N];
        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1] + arr[i];
        }

        int max = sum[X - 1];
        int maxCnt = 1;
        for (int i = X; i < N; i++) {
            final int curSum = sum[i] - sum[i - X];
            if (curSum > max) {
                max = curSum;
                maxCnt = 1;
                continue;
            }

            if (curSum == max) {
                maxCnt++;
            }
        }

		if (max != 0) {
			System.out.println(max);
			System.out.println(maxCnt);
		} else {
			System.out.println("SAD");
		}
    }
}
