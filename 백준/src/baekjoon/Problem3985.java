package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/3985
 */
public class Problem3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[L + 1];

		StringTokenizer st;

		int max = 0;
		int expectMax = 0;
		int expectPerson = 0;
		int realPerson = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (end - start > expectMax) {
				expectMax = end - start;
				expectPerson = i;
			}

			int cnt = 0;
			for (int j = start; j <= end; j++) {
				if (arr[j] != 0) {
					continue;
				}

				arr[j] = i;
				cnt++;
			}

			if (cnt > max) {
				max = cnt;
				realPerson = i;
			}
		}

		System.out.println(expectPerson);
		System.out.println(realPerson);
	}
}
