package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 출처: https://www.acmicpc.net/problem/7662
 */
public class Problem7662 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String EMPTY = "EMPTY";
	public static final String NEW_LINE = "\n";
	public static final String SPACE = " ";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		TreeMap<Integer, Integer> map;
		int T = Integer.parseInt(bf.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(bf.readLine());
			map = new TreeMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());

				if ("I".equals(st.nextToken())) { // 저장
					int value = Integer.parseInt(st.nextToken());
					map.merge(value, 1, Integer::sum); // 중복 처리
					continue;
				}

				if (!map.isEmpty()) {
					if ("1".equals(st.nextToken())) {
						Integer quanitty = map.get(map.lastKey());
						if (quanitty == 1) {
							map.remove(map.lastKey());
						} else {
							map.put(map.lastKey(), --quanitty); //중복일 경우
						}
					} else { // -1일때
						Integer quanitty = map.get(map.firstKey());
						if (quanitty == 1) {
							map.remove(map.firstKey());
						} else {
							map.put(map.firstKey(), --quanitty); //중복일 경우
						}
					}
				}
			}
			if (map.isEmpty()) {
				sb.append(EMPTY);
			} else {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;

				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					for (int i = 0; i < entry.getValue(); i++) {
						max = Math.max(max, entry.getKey());
						min = Math.min(min, entry.getKey());
					}
				}
				sb.append(max).append(SPACE).append(min);
			}
			sb.append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
