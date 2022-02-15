package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2798
 */
public class Problem2798 {

	private static int[] array;
	private static boolean[] isVisited;
	private static int N;
	private static int M;
	private static int answer;
	private static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		array = new int[N];
		isVisited = new boolean[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		permutation(0, 0);

		System.out.println(answer);
	}

	private static void permutation(int start, int depth) {

		if (depth == 3) {
			if (sum <= M) {
				answer = Math.max(answer, sum);
			}
			return;
		}

		for (int i = start; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				sum += array[i];
				permutation(i, depth + 1);
				sum -= array[i];
				isVisited[i] = false;
			}
		}
	}
}
