package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2562
 */
public class Problem2562 {

	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int max = 0;
		int index = 0;
		for (int i = 1; i <= 9; i++) {
			int no = Integer.parseInt(bf.readLine());
			if (max < no) {
				index = i;
				max = no;
			}
		}

		System.out.println(max);
		System.out.println(index);
	}
}
