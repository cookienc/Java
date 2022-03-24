package programmers;

import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {
	static class Solution {
		private static int[][] arr;
		private static List<Integer> list;

		public int[] solution(int rows, int columns, int[][] queries) {

			arr = new int[rows][columns];
			initialize(arr, rows, columns);

			list = new ArrayList<>();
			for (int[] query : queries) {
				change(query);
			}

			return list.stream()
					.mapToInt(e -> e)
					.toArray();
		}

		private static void change(int[] query) {

			int min = Integer.MAX_VALUE;

			int y1 = query[0] - 1;
			int x1 = query[1] - 1;
			int y2 = query[2] - 1;
			int x2 = query[3] - 1;

			int leftUp = arr[y1][x1];
			int rightUp = arr[y1][x2];
			int leftDown = arr[y2][x1];
			int rightDown = arr[y2][x2];

			min = Math.min(min, leftUp);
			min = Math.min(min, rightUp);
			min = Math.min(min, leftDown);
			min = Math.min(min, rightDown);

			//위쪽
			for (int x = x2; x - 1 > x1; x--) {
				arr[y1][x] = arr[y1][x - 1];
				min = Math.min(min, arr[y1][x - 1]);
			}
			//오른쪽
			for (int y = y2; y - 1 > y1; y--) {
				arr[y][x2] = arr[y - 1][x2];
				min = Math.min(min, arr[y - 1][x2]);
			}
			//아래쪽
			for (int x = x1; x + 1 < x2; x++) {
				arr[y2][x] = arr[y2][x + 1];
				min = Math.min(min, arr[y2][x + 1]);
			}
			//왼쪽
			for (int y = y1; y + 1 < y2; y++) {
				arr[y][x1] = arr[y + 1][x1];
				min = Math.min(min, arr[y + 1][x1]);
			}

			arr[y1][x1 + 1] = leftUp;
			arr[y1 + 1][x2] = rightUp;
			arr[y2][x2 - 1] = rightDown;
			arr[y2 - 1][x1] = leftDown;

			list.add(min);
		}

		private static void initialize(int[][] arr, int rows, int columns) {
			int count = 0;
			for (int y = 0; y < rows; y++) {
				for (int x = 0; x < columns; x++) {
					arr[y][x] = ++count;
				}
			}
		}
	}
}
