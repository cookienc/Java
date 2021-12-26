package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1629
 * 참고: https://st-lab.tistory.com/237?category=922819
 */
public class Problem1629 {

	private static int a;
	private static int b;
	private static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		a = Integer.parseInt(stringTokenizer.nextToken());
		b = Integer.parseInt(stringTokenizer.nextToken());
		c = Integer.parseInt(stringTokenizer.nextToken());

		System.out.println(pow(a, b));
	}

	private static long pow(long num, long exponent) {

		if (exponent == 1) {
			return num % c;
		}

		long temp = pow(num, exponent / 2);

		if (exponent % 2 == 1) {
			return (temp  * temp % c) * num % c;
		}

		return temp * temp % c;
	}
}
