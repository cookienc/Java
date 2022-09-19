package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/3029
 */
public class Problem3029 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		String end = br.readLine();

		if (start.equals(end)) {
			System.out.println("24:00:00");
			return;
		}

		System.out.println(timeDiff(start, end));
	}

	private static String timeDiff(String start, String end) {

		StringBuilder time = new StringBuilder();

		String[] endTime = end.split(":");
		String[] startTime = start.split(":");

		boolean minusSecond = false;
		boolean minusMinute = false;

		int endHour = Integer.parseInt(endTime[0]);
		int startHour = Integer.parseInt(startTime[0]);

		int endMinute = Integer.parseInt(endTime[1]);
		int startMinute = Integer.parseInt(startTime[1]);

		int endSecond = Integer.parseInt(endTime[2]);
		int startSecond = Integer.parseInt(startTime[2]);

		int s = endSecond - startSecond;
		if (s < 0) {
			s += 60;
			minusSecond = true;
		}

		int m = endMinute - startMinute;
		if (minusSecond) {
			m--;
		}

		if (m < 0) {
			m += 60;
			minusMinute = true;
		}

		int h = endHour - startHour;
		if (minusMinute) {
			h--;
		}
		if (h < 0) {
			h += 24;
		}

		return time.append(String.format("%02d", h))
				.append(":")
				.append(String.format("%02d", m))
				.append(":")
				.append(String.format("%02d", s)).toString();
	}
}
