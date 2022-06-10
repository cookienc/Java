package baekjoon;

import java.io.*;
import java.util.Arrays;

/**
 * 출처: https://www.acmicpc.net/problem/1427
 */
public class Problem1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = br.readLine();

		Integer[] nums = new Integer[num.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = num.charAt(i) - '0';
		}
		Arrays.sort(nums, (n1, n2) -> n2 - n1);
		for (Integer i : nums) {
			sb.append(i);
		}
		System.out.println(sb);
		br.close();
	}
}
