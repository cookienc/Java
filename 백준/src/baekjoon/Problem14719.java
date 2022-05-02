package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14719
 */
public class Problem14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[][] height = new int[W][3]; //0: 현재값, 1: 현재를 중심으로 왼쪽에서 가장 큰 값, 2: 오른쪽에서 가장 큰 값
		for (int i = 0; i < W; i++) {
			height[i][0] = Integer.parseInt(st.nextToken());
		}

		int max = height[0][0];
		height[0][1] = max;
		for (int i = 1; i < W; i++) {
			max = Math.max(max, height[i][0]);
			height[i][1] = max;
		}

		max = height[W - 1][0];
		height[0][2] = max;
		for (int i = W - 2; i >= 0; i--) {
			max = Math.max(max, height[i][0]);
			height[i][2] = max;
		}

		int water = 0;
		for (int i = 0; i < W; i++) {
			int min = Math.min(height[i][1], height[i][2]);
			if (min == height[i][0]) {
				continue;
			}

			if (min >= height[i][0]) {
				water += min - height[i][0];
			}
		}

		System.out.println(water);
	}
}
