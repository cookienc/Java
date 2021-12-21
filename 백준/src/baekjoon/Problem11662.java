package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11662
 */
public class Problem11662 {

	private static double[] x;
	private static double[] y;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		x = new double[5];
		y = new double[5];

		for (int i = 1; i < 5; i++) {
			x[i] = Integer.parseInt(stringTokenizer.nextToken());
			y[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int time = 1000000;

		double vx1 = (x[2] - x[1]) / time;
		double vy1 = (y[2] - y[1]) / time;
		double vx2 = (x[4] - x[3]) / time;
		double vy2 = (y[4] - y[3]) / time;

		double min = getDistance(x[1], y[1], x[3], y[3]);
		double currentDistance = 0;

		for (int i = 0; i <= time; i++) {
			currentDistance = getDistance(x[1] + vx1 * i, y[1] + vy1 * i,
					x[3] + vx2 * i, y[3] + vy2 * i);

			min = Math.min(currentDistance, min);
		}

		System.out.println(min);
	}

	private static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
