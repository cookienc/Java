package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14890
 * 참고: https://moonsbeen.tistory.com/282
 */
public class Problem14890 {

	private static int N;
	private static int L;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		initialize(br);

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (calRow(i)) {
				count++;
			}

			if (calCol(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean calRow(int row) {
		boolean[] canSet = new boolean[N]; //경사면 설치 여부를 확인하는 배열

		for (int i = 0; i < N - 1; i++) {
			int diff = map[row][i] - map[row][i + 1];

			if (diff > 1 || diff < -1) {
				return false;
			} else if (diff == -1) { // 다음 계단이 한 계단 높다
				for (int j = 0; j < L; j++) { // 경사로를 설치할 수 있는지 확인
					if (i - j < 0 || canSet[i - j]) {
						return false;
					}

					if (map[row][i] != map[row][i - j]) {
						return false;
					}

					canSet[i - j] = true; //경사면 설치
				}
			} else if (diff == 1) { //다음 계단이 한 계단 낮다
				for (int j = 1; j <= L; j++) { //경사로를 설치할 수 있는지 확인
					if (i + j >= N || canSet[i + j]) {
						return false;
					}

					if (map[row][i] - 1 != map[row][i + j]) {
						return false;
					}

					canSet[i + j] = true; //경사면 설치
				}
			}
		}
		return true;
	}

	public static boolean calCol(int col) {
		boolean[] canSet = new boolean[N]; //경사면 설치 여부를 확인하는 배열

		for (int i = 0; i < N - 1; i++) {
			int diff = map[i][col] - map[i + 1][col];

			if (diff > 1 || diff < -1) {
				return false;
			} else if (diff == -1) { // 다음 계단이 한 계단 높다
				for (int j = 0; j < L; j++) { // 경사로를 설치할 수 있는지 확인
					if (i - j < 0 || canSet[i - j]) {
						return false;
					}

					if (map[i][col] != map[i - j][col]) {
						return false;
					}
					canSet[i - j] = true; //경사면 설치
				}
			} else if (diff == 1) { //다음 계단이 한 계단 낮다
				for (int j = 1; j <= L; j++) { //경사로를 설치할 수 있는지 확인
					if (i + j >= N || canSet[i + j]) {
						return false;
					}

					if (map[i][col] - 1 != map[i + j][col]) {
						return false;
					}

					canSet[i + j] = true; //경사면 설치
				}
			}
		}
		return true;
	}

	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
