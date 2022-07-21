package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2281
 */
public class Problem2281 {

	private static int[] arr;
	private static int[][] dp;
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		dp = new int[1000][1002];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(recur(1, arr[0] + 1));
	}

	private static int recur(int nameIdx, int length) {
		if (nameIdx == n) {
			return 0;
		}

		int ans = dp[nameIdx][length];

		if (ans != -1) {
			return ans;
		}

		// 다음줄로 넘어가서 이름을 적는 경우
		int remain = m - length + 1;
		ans = recur(nameIdx + 1, arr[nameIdx] + 1) + (remain * remain);

		// 이어서 이름을 적는 경우
		if (length + arr[nameIdx] <= m) {
			ans = Math.min(ans, recur(nameIdx + 1, length + arr[nameIdx] + 1));
		}

		dp[nameIdx][length] = ans;
		return ans;
	}
}
