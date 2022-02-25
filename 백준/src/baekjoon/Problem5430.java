package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/5430
 */
public class Problem5430 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";
	public static final String ERROR = "error";
	public static final String OPEN_BRACKET = "[";
	public static final String CLOSE_BRACKET = "]";
	public static final String COMMA = ",";
	public static final String DELIM = ",[]";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		List<Integer> list;

		while (T-- > 0) {

			boolean isReversed = false;
			boolean error = false;

			String func = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine(), DELIM);

			list = new ArrayList<>();

			while (n-- > 0) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			String[] functions = func.split("");
			for (String function : functions) {
				if ("R".equals(function)) {
					isReversed = !isReversed;
					continue;
				}

				if (list.isEmpty()) {
					sb.append(ERROR)
							.append(NEW_LINE);
					error = true;
					break;
				}

				if (isReversed) {
					list.remove(list.size() - 1);
				} else {
					list.remove(0);
				}
			}

			if (error) {
				continue;
			}

			listToString(list, isReversed);

		}
		System.out.println(sb);
	}

	private static void listToString(List<Integer> list, boolean reverse) {
		sb.append(OPEN_BRACKET);

		if (list.isEmpty()) {
			sb.append(CLOSE_BRACKET)
					.append(NEW_LINE);
			return;
		}

		if (reverse) {
			for (int i = list.size() - 1; i > 0; i--) {
				sb.append(list.get(i))
						.append(COMMA);
			}
			sb.append(list.get(0))
					.append(CLOSE_BRACKET)
					.append(NEW_LINE);
		} else {
			for (int i = 0; i < list.size() - 1; i++) {
				sb.append(list.get(i))
						.append(COMMA);
			}
			sb.append(list.get(list.size() - 1))
					.append(CLOSE_BRACKET)
					.append(NEW_LINE);
		}
	}
}
