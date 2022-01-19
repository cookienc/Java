package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14888
 */
public class Problem14888 {

	private static int[] number;
	private static int[] param;
	private static boolean[] isVisited;
	private static List<Character> symbol;
	private static char[] symbolArr;
	private static int end;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		number = new int[N];
		param = new int[4];


		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		count = 0;
		for (int i = 0; i < 4; i++) {
			param[i] = Integer.parseInt(stringTokenizer.nextToken());
			count += param[i];
		}

		isVisited = new boolean[count];
		symbol = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			int num = param[i];
			for (int j = 0; j < num; j++) {
				switch (i) {
					case 0:
						symbol.add('+');
						continue;
					case 1:
						symbol.add('-');
						continue;
					case 2:
						symbol.add('x');
						continue;
					case 3:
						symbol.add('/');
						continue;
				}
			}
		}

		end = N - 1;
		symbolArr = new char[end];

		dfs(0);

		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int depth) {
		if (depth == end) {
			int sum = number[0];

			for (int i = 0; i < end; i++) {
				char check = symbolArr[i];

				if (check == '+') {
					sum += number[i + 1];
					continue;
				}

				if (check == '-') {
					sum -= number[i + 1];
					continue;
				}

				if (check == 'x') {
					sum *= number[i + 1];
					continue;
				}

				if (check == '/') {
					sum /= number[i + 1];
					continue;
				}
			}

			max = Math.max(sum, max);
			min = Math.min(sum, min);

			return;
		}

		for (int i = 0; i < count; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				symbolArr[depth] = symbol.get(i);
				dfs(depth + 1);
				isVisited[i] = false;
			}
		}
	}
}
