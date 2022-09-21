package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/3079
 */
public class Problem3079 {
	private static int[] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		time = new int[N];

		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(time);

		long start = -1;
		long end = (long)time[time.length - 1] * M;

		while (start + 1 != end) {
			long mid = start + (end - start) / 2;
			long people = getPeople(mid);

			if (people >= M) {
				end = mid;
				continue;
			}

			if (people < M) {
				start = mid;
			}
		}
		System.out.println(end);
	}

	private static long getPeople(long i) {
		long sum = 0;
		for (int t : time) {
			sum += i / t;
		}
		return sum;
	}
}
