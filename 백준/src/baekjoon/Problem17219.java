package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 출처: https://www.acmicpc.net/problem/17219
 */
public class Problem17219 {

	public static final String NEW_LINE = "\n";
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String> memo = new TreeMap<>();

		while (N-- > 0) {
			st = new StringTokenizer(bf.readLine());
			String site = st.nextToken();
			String password = st.nextToken();

			memo.put(site, password);
		}

		while (M-- > 0) {
			String site = bf.readLine();

			sb.append(memo.get(site))
					.append(NEW_LINE);
		}

		System.out.println(sb);
	}
}
