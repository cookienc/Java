package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14425
 */
public class Problem14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), true);
		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
			if (map.containsKey(br.readLine())) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
