package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2003
 */
public class Problem2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int low = 0;
		int high = 0;
		int count = 0;
		int sum = array[0];
		while (true) {

			if (sum == M) {
				count++;
			}

			if (sum < M) {

				if (++high >= N) {
					break;
				}

				sum += array[high];
				continue;
			}

			sum -= array[low++];
		}

		System.out.println(count);
	}
}
