package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9375
 */
public class Problem9375 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		Map<String, Integer> clothes;

		StringTokenizer st;
		while (T-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			clothes = new HashMap<>();

			while (n-- > 0) {
				st = new StringTokenizer(bf.readLine());

				String name = st.nextToken();
				String type = st.nextToken();

				clothes.merge(type, 1, Integer::sum);
			}

			Object[] key = clothes.keySet().toArray();

			if (key.length == 1) {
				sb.append(clothes.get((String) key[0]))
						.append(NEW_LINE);
			} else {
				int count = 1;
				for (int i = 0; i < key.length; i++) {
					count *= clothes.get((String) key[i]) + 1;
				}
				sb.append(count - 1)
						.append(NEW_LINE);
			}
		}
		System.out.println(sb);
	}
}
