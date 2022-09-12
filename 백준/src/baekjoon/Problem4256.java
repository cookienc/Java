package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/4256
 */
public class Problem4256 {

	private static int[] pre;
	private static int[] in;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			pre = new int[n + 1];
			in = new int[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}

			traversal(0, 0, n);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void traversal(int root, int s, int e) {
		int rootValue = pre[root];
		for (int i = s; i < e; i++) {
			if (in[i] == rootValue) {
				traversal(root + 1, s, i);
				traversal(root + i + 1 - s, i + 1, e);
				sb.append(rootValue + " ");
			}
		}
	}
}
