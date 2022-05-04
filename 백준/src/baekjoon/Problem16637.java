package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 출처: https://www.acmicpc.net/problem/16637
 */
public class Problem16637 {

	private static List<Integer> number;
	private static List<Character> operation;
	private static int[] choice;
	private static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String op = new String(str);

		number = new ArrayList<>();
		operation = new ArrayList<>();
				divideWord(str, op);

		dfs(number.get(0), 0);

		System.out.println(answer);
	}

	private static void dfs(int result, int opIdx) {
		if (opIdx >= operation.size()) {
			answer = Math.max(answer, result);
			return;
		}

		int res = calc(result, operation.get(opIdx), number.get(opIdx + 1));
		dfs(res, opIdx + 1);

		if (opIdx + 1 < operation.size()) {
			int resWithBracket = calc(number.get(opIdx + 1), operation.get(opIdx + 1), number.get(opIdx + 2));
			dfs(calc(result, operation.get(opIdx), resWithBracket), opIdx + 2);
		}
	}

	public static int calc(int n1, char op, int n2) {
		switch (op) {
			case '+':
				return n1 + n2;
			case '-':
				return n1 - n2;
			case '*':
				return n1 * n2;
		}
		return -1;
	}

	private static void divideWord(String str, String op) {
		str = str.replaceAll("[+\\-*]", "");
		op = op.replaceAll("[0-9]", "");

		for (int i = 0; i < str.length(); i++) {
			number.add(str.charAt(i) - '0');
		}

		for (int i = 0; i < op.length(); i++) {
			operation.add(op.charAt(i));
		}
	}
}
