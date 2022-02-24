package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11723
 */
public class Problem11723 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String ONE = "1";
	public static final String NEW_LINE = "\n";
	public static final String ZERO = "0";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(bf.readLine());

		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st;
		while (M-- > 0) {
			st = new StringTokenizer(bf.readLine());
			String operation = st.nextToken();

			if ("all".equals(operation)) {
				for (int i = 1; i <= 20; i++) {
					map.put(i, i);
				}
				continue;
			}

			if ("empty".equals(operation)) {
				map.clear();
				continue;
			}

			int num = Integer.parseInt(st.nextToken());

			if ("add".equals(operation)) {
				map.put(num, num);
				continue;
			}

			if ("remove".equals(operation)) {
				if (map.containsKey(num)) {
					map.remove(num);
				}
				continue;
			}

			if ("check".equals(operation)) {
				if (map.containsKey(num)) {
					sb.append(ONE)
							.append(NEW_LINE);
				} else {
					sb.append(ZERO)
							.append(NEW_LINE);
				}
				continue;
			}

			if ("toggle".equals(operation)) {
				if (map.containsKey(num)) {
					map.remove(num);
				} else {
					map.put(num, num);
				}
				continue;
			}
		}
		System.out.println(sb);
	}
}
