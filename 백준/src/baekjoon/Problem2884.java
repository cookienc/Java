package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2884
 */
public class Problem2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String time = calculateAlarm(H, M);
		System.out.println(time);
	}

	private static String calculateAlarm(int h, int m) {

		if (m < 45) {
			h -= 1;
			if (h < 0) {
				h = 23;
			}

			m += 60;
		}

		m -= 45;

		return h + " " + m;
	}
}
