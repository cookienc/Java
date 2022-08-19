package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 출처: https://www.acmicpc.net/problem/5639
 */
public class Problem5639 {

	private static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		list = new ArrayList<>();
		while (true) {
			String tmp = br.readLine();

			if (tmp == null || tmp.isBlank()) {
				break;
			}

			int value = Integer.parseInt(tmp);
			list.add(value);
		}
		postOrder(0, list.size() - 1);
	}

	private static void postOrder(int start, int end) {
		if (start > end) {
			return;
		}

		int next = start + 1;
		while (next <= end && list.get(next) < list.get(start)) {
			next++;
		}

		postOrder(start + 1, next - 1);
		postOrder(next, end);
		System.out.println(list.get(start));
	}
}
