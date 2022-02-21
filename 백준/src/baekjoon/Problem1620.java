package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1620
 */
public class Problem1620 {

	public static final String NEW_LINE = "\n";
	public static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> englishDic = new HashMap<>();
		String[] numericDic = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			String word = bf.readLine();
			englishDic.put(word, i);
			numericDic[i] = word;
		}

		for (int i = 0; i < M; i++) {
			String question = bf.readLine();
			if (question.chars().allMatch(Character::isDigit)) {
				sb.append(numericDic[Integer.parseInt(question)])
						.append(NEW_LINE);
				continue;
			}

			sb.append(englishDic.get(question))
					.append(NEW_LINE);
		}

		System.out.println(sb);
	}
}
