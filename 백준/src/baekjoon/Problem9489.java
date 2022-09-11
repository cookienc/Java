package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9489
 */
public class Problem9489 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (n == 0 && k == 0) {
				break;
			}

			int[] arr = new int[n + 1];
			int[] type = new int[n + 1];

			arr[0] = -1;
			type[0] = -1;

			int t = -1;
			int target = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] == k) {
					target = i;
				}

				if (arr[i] != arr[i - 1] + 1) {
					t++;
				}

				type[i] = t;
			}

			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (type[i] != type[target] && type[type[i]] == type[type[target]]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}
