package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/1935
 */
public class Problem1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Double> num = new Stack<>();

		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];

			if ('A' <= ch && ch <= 'Z') {
				double d = arr[ch - 'A'];
				num.push(d);
				continue;
			}

			double d1 = num.pop();
			double d2 = num.pop();
			double d3 = 0.0;

			switch (ch) {
				case '+':
					d3 = d2 + d1;
					break;
				case '-':
					d3 = d2 - d1;
					break;
				case '*':
					d3 = d2 * d1;
					break;
				case '/':
					d3 = d2 / d1;
					break;
			}

			num.push(d3);
		}
		System.out.printf("%.2f", num.pop());
	}
}
