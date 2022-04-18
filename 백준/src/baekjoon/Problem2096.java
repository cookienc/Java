package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[1][3];
		int[][] min = new int[1][3];
		int[][] max = new int[1][3];
		int[][] tmp = new int[1][3];

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		min[0][0] = Integer.parseInt(st.nextToken());
		min[0][1] = Integer.parseInt(st.nextToken());
		min[0][2] = Integer.parseInt(st.nextToken());

		max[0][0] = min[0][0];
		max[0][1] = min[0][1];
		max[0][2] = min[0][2];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][0] = Integer.parseInt(st.nextToken());
			arr[0][1] = Integer.parseInt(st.nextToken());
			arr[0][2] = Integer.parseInt(st.nextToken());

			tmp[0][0] = Math.min(min[0][0], min[0][1]) + arr[0][0];
			tmp[0][1] = Math.min(min[0][0], Math.min(min[0][1], min[0][2])) + arr[0][1];
			tmp[0][2] = Math.min(min[0][1], min[0][2]) + arr[0][2];

			min[0][0] = tmp[0][0];
			min[0][1] = tmp[0][1];
			min[0][2] = tmp[0][2];

			tmp[0][0] = Math.max(max[0][0], max[0][1]) + arr[0][0];
			tmp[0][1] = Math.max(max[0][0], Math.max(max[0][1], max[0][2])) + arr[0][1];
			tmp[0][2] = Math.max(max[0][1], max[0][2]) + arr[0][2];


			max[0][0] = tmp[0][0];
			max[0][1] = tmp[0][1];
			max[0][2] = tmp[0][2];
		}

		System.out.println(Math.max(Math.max(max[0][0], max[0][1]), max[0][2]) +
				" " +
				Math.min(Math.min(min[0][0], min[0][1]), min[0][2])
		);
	}
}
