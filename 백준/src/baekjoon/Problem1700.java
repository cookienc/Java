package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1700 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] seq = new int[K];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}


		Set<Integer> set = new HashSet<>();

		int cnt = 0;
		for (int i = 0; i < K; i++) {
			int num = list.get(i);

			if (set.contains(num)) {
				continue;
			}

			if (set.size() < N && set.add(num)) {
				continue;
			}

			int max = -1, idx = -1;
			for (int s : set) {
				int tmp = 0;
				List<Integer> sub = list.subList(i + 1, K);
				if (sub.contains(s)) {
					tmp = sub.indexOf(s) + 1;
				} else {
					tmp = K - i - 1;
				}

				if (tmp > max) {
					max = tmp;
					idx = s;
				}
			}
			set.remove(idx);
			set.add(num);
			cnt++;
		}

		System.out.println(cnt);
	}
}
