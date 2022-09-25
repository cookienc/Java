package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 출처: https://www.acmicpc.net/problem/5597
 */
public class Problem5597 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= 30; i++) {
			set.add(i);
		}
		for (int i = 0; i < 28; i++) {
			set.remove(Integer.parseInt(br.readLine()));
		}

		for (Integer i : set) {
			System.out.println(i);
		}
	}
}
