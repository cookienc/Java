package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1057 {

	private static int N;
	private static int a;
	private static int b;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		N = Integer.parseInt(stringTokenizer.nextToken());
		a = Integer.parseInt(stringTokenizer.nextToken());
		b = Integer.parseInt(stringTokenizer.nextToken());

		int count = 0;
		
		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			count++;
		}
		System.out.println(count);
	}

}
