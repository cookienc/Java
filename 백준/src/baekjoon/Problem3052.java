package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 출처: https://www.acmicpc.net/problem/3052
 */
public class Problem3052 {

	public static final int MOD = 42;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Map<Integer, Boolean> checked = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(bf.readLine()) % MOD;
			checked.put(num, true);
		}

		System.out.println(checked.size());
	}
}

