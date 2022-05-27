package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2437
 */
public class Problem2437 {

	private static int[] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		weight = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(weight);

		int sum = 1;
		for (int i = 0; i < N; i++) {
			if (sum < weight[i]) {
				break;
			}
			sum += weight[i];
		}

		System.out.println(sum);
	}

}
