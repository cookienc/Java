package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.function.BiFunction;

/**
 * 출처: https://www.acmicpc.net/problem/2935
 */
public class Problem2935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		BigInteger num1 = new BigInteger(A);

		String op = br.readLine();

		String B = br.readLine();
		BigInteger num2 = new BigInteger(B);

		switch (op) {
			case "+":
				System.out.println(num1.add(num2));
				break;
			case "-":
				System.out.println(num1.subtract(num2));
				break;
			case "*":
				System.out.println(num1.multiply(num2));
				break;
			case "/":
				System.out.println(num1.divide(num2));
				break;
		}

	}
}
