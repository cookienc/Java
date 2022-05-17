package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 출처: https://www.acmicpc.net/problem/1744
 */
public class Problem1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(br.readLine());
			return;
		}

		List<Integer> plus = new LinkedList<>();
		List<Integer> minus = new LinkedList<>();
		boolean zero = false;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				zero = true;
				continue;
			}

			if (num > 0) {
				plus.add(num);
				continue;
			}

			minus.add(num);
		}

		if (zero && ((minus.size() % 2) == 1)) {
			minus.add(0);
		}

		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);

		int sum = 0;
		for (int i = 0; i < plus.size(); i++) {
			if (i + 1 < plus.size()) {
				if (plus.get(i) * plus.get(i + 1) > plus.get(i) + plus.get(i + 1)) {
					sum += plus.get(i) * plus.get(i + 1);
					i++;
					continue;
				}
			}
			sum += plus.get(i);
		}

		for (int i = 0; i < minus.size(); i++) {
			if (i + 1 < minus.size()) {
				sum += minus.get(i) * minus.get(i + 1);
				i++;
				continue;
			}
			sum += minus.get(i);
		}

		System.out.println(sum);
	}
}
