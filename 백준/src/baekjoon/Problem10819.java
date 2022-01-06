package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10819 {

	private static int[] array;
	private static boolean[] isVisited;
	private static int max = Integer.MIN_VALUE;


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		array = new int[n];
		int length = array.length;
		int[] output = new int[length];
		isVisited = new boolean[length];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			array[i]= Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(array);

		perm(output, 0, length, n);

		System.out.println(max);

	}

	private static void perm(int[] output, int depth, int n, int r){
		if (depth == r) {
			findMax(output, r);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isVisited[i] == false) {
				isVisited[i] = true;
				output[depth] = array[i];
				perm(output, depth + 1, n, r);
				isVisited[i] = false;
			}
		}
	}

	private static void findMax(int[] arr, int n) {
		int sum = 0;

		for (int i = 0; i < n - 1; i++) {
			sum += Math.abs(arr[i] - arr[i + 1]);
		}

		max = Math.max(sum, max);
	}
}
