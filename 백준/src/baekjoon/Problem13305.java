package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/13305
 */
public class Problem13305 {

	private static int[] city;
	private static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine());

		city = new int[n];
		distance = new int[n - 1];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			city[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int total = 0;
		for (int i = 0; i < n - 1; i++) {
			if (city[i] > city[i + 1]) {
				total += city[i] * distance[i];
				continue;
			}

			int tempDistance = distance[i];
			int count = 1;
			for (int j = i + 1; j < n - 1; j++) {
				if (city[i] > city[j]) {
					i = j;
					break;
				}
				tempDistance += distance[j];
				count++;
			}
			total += city[i] * tempDistance;
			i += count;
		}

		System.out.println(total);
	}
}
