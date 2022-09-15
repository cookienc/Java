package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2961
 */
public class Problem2961 {
	
	private static Food[] foods;
	private static int N;
	private static int end;
	private static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		foods = new Food[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			foods[i] = new Food(s, b);
		}

		for (int i = 0; i < N; i++) {
			end = i;
			dfs(0, 0, 0);
		}
		System.out.println(answer);
	}

	private static void dfs(int depth, int start ,int flag) {

		if (depth == end) {
			int S = 1;
			int B = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & (1 << i)) != 0) {
					continue;
				}
				S *= foods[i].s;
				B += foods[i].b;
			}
			answer = Math.min(answer, Math.abs(S - B));
			return;
		}

		for (int i = start; i < N; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}

			flag |= 1 << i;
			dfs(depth + 1, i, flag);
			flag &= ~(1 << i);
		}
	}

	private static class Food {
		int s;
		int b;

		public Food(int s, int b) {
			this.s = s;
			this.b = b;
		}
	} 
}
