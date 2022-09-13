package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/21758
 */
public class Problem21758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] honey = new long[N];
		long[] toLeft = new long[N];
		for (int i = 0; i < N; i++) {
			honey[i] = Long.parseLong(st.nextToken());

			if (i == 0) {
				toLeft[i] = honey[i];
				continue;
			}

			toLeft[i] = toLeft[i - 1] + honey[i];
		}

		long[] toRight = new long[N];
		for (int i = N - 1; i >= 0; i--) {
			if (i == N - 1) {
				toRight[i] = honey[i];
				continue;
			}

			toRight[i] = toRight[i + 1] + honey[i];
		}

		long max = 0;
		for (int house = 0; house < N; house++) {
			if (house == 0) {
				for (int i = N - 2; i >= 1; i--) {
					long val = toRight[0] * 2 - toRight[N - 1] - toRight[i] - honey[i];
					max = Math.max(max, val);
				}
				continue;
			}

			if (house == N - 1) {
				for (int i = 1; i < N - 1; i++) {
					long val = toLeft[N - 1] * 2 - toLeft[0] - toLeft[i] - honey[i];
					max = Math.max(max, val);
				}
				continue;
			}

			long val = toLeft[house] + toRight[house] - toLeft[0] - toRight[N - 1];
			max = Math.max(max, val);
		}

		System.out.println(max);
	}
}
