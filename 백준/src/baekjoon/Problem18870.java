package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/18870
 */
public class Problem18870 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String SPACE = " ";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		Integer[] array = new Integer[N];
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (Integer i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Integer[] clone = Arrays.copyOf(array, array.length);
		Arrays.sort(array);

		map.put(array[0], 0);
		for (Integer i = 1, count = 0; i < N; i++) {
			if (array[i].equals(array[i - 1])) {
				map.put(array[i], count);
				continue;
			}
			map.put(array[i], ++count);
		}
		for (Integer i : clone) {
			sb.append(map.get(i))
					.append(SPACE);
		}
		System.out.println(sb);
	}
}
