package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/22864
 */
public class Problem22864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int throughput = 0;
		int fatigue = 0;
		for (int i = 0; i < 24; i++) {
			if (fatigue + A > M) {
				fatigue -= C;

				if (fatigue < 0) {
					fatigue = 0;
				}

				continue;
			}

			fatigue += A;
			throughput += B;
		}
		System.out.println(throughput);
	}
}
