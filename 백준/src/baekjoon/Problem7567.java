package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/7567
 */
public class Problem7567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();

		int sum = 10;
		for (int i = 1; i < word.length; i++) {
			if (word[i] == word[i - 1]) {
				sum += 5;
			} else {
				sum += 10;
			}
		}

		System.out.println(sum);
	}
}
