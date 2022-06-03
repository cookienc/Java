package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/12015
 */
public class Problem12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		List<Integer> lis = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		lis.add(arr[0]);

		for (int i = 1; i < N; i++) {
			int flag = arr[i];

			int low = -1;
			int high = lis.size();

			while (low + 1 < high) {
				int mid = low + ((high - low) / 2);

				if (lis.get(mid) >= flag) {
					high = mid;
				} else {
					low = mid;
				}
			}

			if (high == lis.size()) {
				lis.add(flag);
				continue;
			}

			if (lis.get(high) > flag) {
				lis.set(high, flag);
			}
		}

		System.out.println(lis.size());
	}
}
