package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/13904
 */
public class Problem13904 {

	private static List<Homework> homework;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		homework = new ArrayList<>();
		int maxDate = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			homework.add(new Homework(d, w));
			maxDate = Math.max(maxDate, d);
		}

		int sum = 0;
		for (int i = maxDate; i > 0; i--) {
			sum += getMaximumScore(i);
		}
		System.out.println(sum);
	}

	public static int getMaximumScore(int now) {
		int idx = -1;
		int result = 0;
		for (int i = 0; i < homework.size(); i++) {
			if (homework.get(i).day >= now && result < homework.get(i).weight) {
				idx = i;
				result = homework.get(i).weight;
			}
		}

		if (result == 0) {
			return 0;
		}

		homework.remove(idx);
		return result;
	}

	private static class Homework {
		int day;
		int weight;

		public Homework(int day, int weight) {
			this.day = day;
			this.weight = weight;
		}
	}
}



