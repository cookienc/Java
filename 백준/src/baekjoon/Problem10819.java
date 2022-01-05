package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10819 {

	private static int[] array;
	private static int max = Integer.MIN_VALUE;


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		array = new int[n];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			array[i]= Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(array);

		perm(array, 0, n);

		System.out.println(max);

	}

	private static void perm(int[] a, int depth, int num){
		if (depth == num) {
			findMax(a, num);
			return;
		}
		for (int i = depth; i < num; i++) {
			swap(a, i, depth);
			perm(a, depth + 1, num);
			swap(a, i, depth);
		}
	}


	private static void swap(int[] array, int index, int n) {
		int temp = array[index];
		array[index] = array[n];
		array[n] = temp;
	}

	private static void findMax(int[] arr, int n) {
		int sum = 0;

		for (int i = 0; i < n - 1; i++) {
			sum += Math.abs(arr[i] - arr[i + 1]);
		}

		max = Math.max(sum, max);
	}
}
