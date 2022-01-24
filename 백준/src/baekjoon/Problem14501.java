package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14501
 * 참고: https://lemonlemon.tistory.com/4
 */
public class Problem14501 {

	static int[] time;
	static int[] pay;
	static int N;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());

		time = new int[N + 1];
		pay = new int[N + 1];

		StringTokenizer stringTokenizer;
		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			time[i] = Integer.parseInt(stringTokenizer.nextToken());
			pay[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		goTo(1, 0);
		System.out.println(answer);
	}

	static void goTo(int day, int sum) {
		if (day == N + 1) {
			answer = Math.max(answer, sum);
			return;
		}
		if (day > N + 1) {
			return;
		}

		goTo(day + time[day], sum + pay[day]);
		goTo(day + 1, sum);
	}
}
