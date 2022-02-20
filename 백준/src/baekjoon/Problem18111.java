package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/18111
 */
public class Problem18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[M][N];

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}


		int minTime = Integer.MAX_VALUE;
		int floor = 0;

		for (int height = min; height <= max; height++) {
			int time = 0;
			int block = B;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					int diff = map[i][j] - height;

					if (diff > 0) {
						time += diff * 2;
						block += diff;
					} else {
						time += (-diff);
						block -= (-diff);
					}
				}
			}
			if (block < 0) {
				continue;
			}

			if (minTime >= time) {
				minTime = time;
				floor = height;
			}
		}

		System.out.println(minTime + " " + floor);

	}
}
