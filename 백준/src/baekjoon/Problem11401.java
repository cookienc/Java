package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11401 {

	private static int num = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int k = Integer.parseInt(stringTokenizer.nextToken());

		System.out.println(combination(n, k));
	}

	private static int combination(int n, int k) {

		if (k == 0 || n == 1 || k == n) {
			return 1;
		}

		if (k == 1) {
			return n % num;
		}

		int temp = combination(n - 1, k - 1) % num + combination(n - 1, k) % num;

		return temp % num;
	}
}
