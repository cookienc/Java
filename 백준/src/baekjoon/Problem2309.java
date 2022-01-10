package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2309 {

	private static int[] array;
	private static int[] answerArray;
	private static boolean[] isVisited;
	private static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		array = new int[9];
		answerArray = new int[7];
		isVisited = new boolean[9];

		for (int i = 0; i < 9; i++) {
			array[i] = Integer.parseInt(bufferedReader.readLine());
		}

		Arrays.sort(array);

		dfs(0);

	}

	private static void dfs(int depth) {
		if (depth == 7 && sum == 100) {
			Arrays.sort(answerArray);
			for (int i : answerArray) {
				System.out.println(i);
			}
			System.exit(0);
		}

		if (depth == 7) {
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				answerArray[depth] = array[i];
				sum += array[i];
				dfs(depth + 1);
				isVisited[i] = false;
				sum -= array[i];
			}
		}
	}
}
