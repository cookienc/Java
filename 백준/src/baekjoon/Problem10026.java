package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10026
 */
public class Problem10026 {

	public static final String SPACE = " ";
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};

	private static Character[][] picture;
	private static Character[][] pictureWithDisease;
	private static boolean[][] isVisited;
	private static final StringBuilder sb = new StringBuilder();
	private static int N = 0;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());

		picture = new Character[N][N];
		pictureWithDisease = new Character[N][N];
		isVisited = new boolean[N][N];

		initializePic(bf, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					count++;
					bfs(picture, i, j);
				}
			}
		}

		sb.append(count).append(SPACE);

		isVisited = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					count++;
					bfs(pictureWithDisease, i, j);
				}
			}
		}
		sb.append(count);
		System.out.println(sb);
	}

	private static void bfs(Character[][] pic, int x, int y) {
		Queue<Index> queue = new LinkedList<>();
		Character type = pic[x][y];
		isVisited[x][y] = true;

		queue.add(new Index(x, y));
		while (!queue.isEmpty()) {
			Index index = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = index.x + dx[i];
				int nextY = index.y + dy[i];

				if (isNotRange(nextX, nextY) ||
						isVisited[nextX][nextY] ||
						doesNotMatch(type, nextY, pic[nextX])) {
					continue;
				}

				isVisited[nextX][nextY] = true;
				queue.add(new Index(nextX, nextY));
			}
		}
	}

	private static boolean doesNotMatch(Character type, int nextY, Character[] pic) {
		return pic[nextY] != type;
	}

	private static boolean isNotRange(int nextX, int nextY) {
		return nextX < 0 || nextY < 0 || nextX >= N || nextY >= N;
	}

	private static void initializePic(BufferedReader bf, int N) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String word = st.nextToken();

			for (int j = 0; j < N; j++) {
				char color = word.charAt(j);

				picture[i][j] = color;

				if (color == 'G') {
					pictureWithDisease[i][j] = 'R';
					continue;
				}
				pictureWithDisease[i][j] = color;
			}
		}
	}

	private static class Index {
		int x;
		int y;

		public Index(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
