package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ClickKeypad {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
		System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
		System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
	}
	private static int[] leftBt = {1, 4, 7};
	private static int[] rightBt = {3, 6, 9};
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static boolean[][] isVisited = new boolean[4][3];
	private static String[][] keyPad = {{"1", "2", "3"},
			{"4", "5", "6"},
			{"7", "8", "9"},
			{"*", "0", "#"}};

	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		String leftPosition = "*";
		String rightPosition = "#";
		for (int num : numbers) {
			if (isItLeftBt(num)) {
				leftPosition = String.valueOf(num);
				sb.append("L");
				continue;
			}

			if (isItRightBt(num)) {
				rightPosition = String.valueOf(num);
				sb.append("R");
				continue;
			}

			//가까운거 고르기
			int rightToTarget = distance(String.valueOf(num), rightPosition);
			int leftToTarget = distance(String.valueOf(num), leftPosition);
			if (rightToTarget == leftToTarget) {
				if ("right".equals(hand)) {
					rightPosition = String.valueOf(num);
					sb.append("R");
				} else {
					leftPosition = String.valueOf(num);
					sb.append("L");
				}
			} else if (rightToTarget > leftToTarget) {
				leftPosition = String.valueOf(num);
				sb.append("L");
			} else {
				rightPosition = String.valueOf(num);
				sb.append("R");
			}
		}
		return sb.toString();
	}

	private static boolean isItLeftBt(int num) {
		for (int i = 0; i < 3; i++) {
			if (leftBt[i] == num) {
				return true;
			}
		}

		return false;
	}

	private static boolean isItRightBt(int num) {
		for (int i = 0; i < 3; i++) {
			if (rightBt[i] == num) {
				return true;
			}
		}

		return false;
	}

	private static int distance(String target, String position) {
		isVisited = new boolean[4][3];
		Queue<Node> queue = new LinkedList<>();

		Node targetNode = findNode(target);
		Node curNode = findNode(position);

		isVisited[curNode.y][curNode.x] = true;
		queue.offer(curNode);
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (targetNode.y == cur.y && targetNode.x == cur.x) {
				min = Math.min(min, cur.distance);
			}

			int dis = cur.distance;

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= 3 || nextY >= 4) {
					continue;
				}

				if (isVisited[nextY][nextX]) {
					continue;
				}

				isVisited[nextY][nextX] = true;
				queue.offer(new Node(nextY, nextX, dis + 1));
			}
		}
		return min;
	}
	public static class Node {
		int y;
		int x;
		int distance;

		public Node(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}

	public static Node findNode(String pos){
		int y = 0;
		int x = 0;

		for (int i = 0; i < 4; i++) {
			boolean flag = false;
			for (int j = 0; j < 3; j++) {
				if (keyPad[i][j].equals(pos)) {
					y = i;
					x = j;
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		return new Node(y, x, 0);
	}
}


