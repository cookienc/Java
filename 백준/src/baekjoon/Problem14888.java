package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14888
 * 참고: https://st-lab.tistory.com/121
 */
public class Problem14888 {

	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	public static int[] operator = new int[4];
	public static int[] number;
	public static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bufferedReader.readLine());
		number = new int[N];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		dfs(number[0], 1);

		System.out.println(MAX);
		System.out.println(MIN);

	}

	public static void dfs(int num, int index) {
		if (index == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (operator[i] > 0) {

				operator[i]--;

				switch (i) {

					case 0:
						dfs(num + number[index], index + 1);
						break;
					case 1:
						dfs(num - number[index], index + 1);
						break;
					case 2:
						dfs(num * number[index], index + 1);
						break;
					case 3:
						dfs(num / number[index], index + 1);
						break;

				}
				operator[i]++;
			}
		}
	}

}