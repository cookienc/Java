package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 출처: https://www.acmicpc.net/problem/1339
 */
public class Problem1339 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			int length = word.length() - 1;

			for (int j = length; j >= 0; j--) {
				map.merge(word.charAt(length - j), (int) Math.pow(10, j), Integer::sum);
			}
		}

		Character[] arr = map.entrySet().stream()
				.sorted((a, b) -> b.getValue() - a.getValue())
				.map(Map.Entry::getKey)
				.toArray(Character[]::new);

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (9 - i) * map.get(arr[i]);
		}

		System.out.println(sum);
	}
}
