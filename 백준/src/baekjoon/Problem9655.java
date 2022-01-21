package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/9655
 */
public class Problem9655 {

	private static Boolean[] dp = new Boolean[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bufferedReader.readLine());


		boolean winner = play(num);

		if (winner) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

	private static boolean play(int num) {

		if (num == 1) {
			return true;
		}
		
		if (dp[num] == null) {
			dp[num] = !play(num - 1);
		}


		return dp[num];
	}

}
