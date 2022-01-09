package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/9663
 * 참고: https://st-lab.tistory.com/118?category=862595
 */
public class Problem9663 {

	public static int[] arr;
	public static int N;
	public static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
		arr = new int[N];

		nQueen(0);
		System.out.println(count);

	}

	public static void nQueen(int depth) {

		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (Possibility(depth)) {
				nQueen(depth + 1);
			}
		}

	}

	public static boolean Possibility(int column) {
		return !isPossiblePosition(column);
	}

	private static boolean isPossiblePosition(int column) {
		for (int i = 0; i < column; i++) {
			if (isDiagonal(column, i) || isStraight(column, i)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isDiagonal(int column, int i) {
		return Math.abs(column - i) == Math.abs(arr[column] - arr[i]);
	}

	private static boolean isStraight(int column, int i) {
		return arr[column] == arr[i];
	}

}