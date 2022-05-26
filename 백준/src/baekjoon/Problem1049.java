package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1049
 */
public class Problem1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] line = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int set = Integer.parseInt(st.nextToken());
			int piece = Integer.parseInt(st.nextToken());

			if (set == 0 || piece == 0) {
				System.out.println(0);
				return;
			}

			line[i][0] = set;
			line[i][1] = piece;
		}
		Arrays.sort(line, Comparator.comparingInt(l -> l[0]));
		int minimumSet = line[0][0];
		int sum = N / 6 * minimumSet;

		Arrays.sort(line, Comparator.comparingInt(l -> l[1]));

		int rest = N % 6;
		int minimumPiece = line[0][1];

		if (minimumPiece * 6 <= minimumSet) {
			sum = N * minimumPiece;
			System.out.println(sum);
			return;
		}

		if (rest * minimumPiece < minimumSet) {
			sum += rest * minimumPiece;
		} else {
			sum += minimumSet;
		}

		System.out.println(sum);
	}
}
