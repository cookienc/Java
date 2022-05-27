package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 출처: https://www.acmicpc.net/problem/1644
 */
public class Problem1644 {
	private static int n;
	private static boolean[] isPrime;
	private static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		makePrime();

		int low = 0;
		int high = 0;
		int sum = 0;
		int cnt = 0;

		if (isPrime[n]) {
			cnt++;
		}
		while (low <= high && high < list.size()) {
			if (sum < n) {
				sum += list.get(high++);
				continue;
			}

			if (sum == n) {
				cnt++;
			}
			sum -= list.get(low++);
		}

		System.out.println(cnt);
	}

	private static void makePrime() {
		isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (isPrime[i]) {
				list.add(i);
			}
		}

	}
}
