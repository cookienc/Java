package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/20922
 */
public class Problem20922 {

	private static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> cnt = new HashMap<>();
		int left = 0;
		int right = 0;
		int total = 0;

		while (left <= right && right < N) {
			int value = arr[right];
			if (cnt.containsKey(value)) {
				Integer num = cnt.get(value);
				if (num < K) {
					cnt.merge(value, 1, Integer::sum);
					total++;
				} else {
					cnt.merge(arr[right], 1, Integer::sum);
					total++;

					while (true) {
						cnt.merge(arr[left], -1, Integer::sum);
						total--;

						if (arr[left++] == value) {
							break;
						}
					}
				}
			} else {
				cnt.put(value, 1);
				total++;
			}
			answer = Math.max(answer, total);
			right++;
		}
		System.out.println(answer);
	}
}
