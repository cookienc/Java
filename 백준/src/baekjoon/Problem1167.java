package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1167
 * 참고: https://moonsbeen.tistory.com/101
 * 		-> 트리에서 가장 먼 지점은 항상 가장 먼 지점 둘 중 하나가 포함 됨.
 * 		-> dfs를 먼저 써서 가장 먼 지점을 구하고 또 한번을 써서 가장 먼 지점으로 부터 가장 먼 지점을 구함.
 * 		-> dfs 2번 쓰면 된다는 것을 알게 됨.
 */
public class Problem1167 {

	private static List<Node>[] lists;
	private static boolean[] isVisited;

	private static Node maxNode = new Node(0, 0); // 정점과 거리;
	private static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		int v = Integer.parseInt(bufferedReader.readLine());

		lists = new ArrayList[v + 1];
		isVisited = new boolean[v + 1];
		distance = new int[v + 1];

		for (int i = 1; i < v + 1; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 1; i < v + 1; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			boolean check = false;
			while (true) {
				int number = Integer.parseInt(stringTokenizer.nextToken());

				if (number == -1) {
					break;
				}

				while (stringTokenizer.hasMoreTokens()) {
					int vertex = Integer.parseInt(stringTokenizer.nextToken());
					if (vertex == -1) {
						check = true;
						break;
					}
					int distance = Integer.parseInt(stringTokenizer.nextToken());

					lists[number].add(new Node(vertex, distance));
				}

				if (check) {
					break;
				}
			}
		}

		dfs(1);
		maxNode.distance = 0;
		distance = new int[v + 1];
		isVisited = new boolean[v + 1];
		dfs(maxNode.vertex);

		System.out.println(maxNode.distance);
	}

	private static void dfs(int num) {
		if (isVisited[num]) {
			return;
		}

		isVisited[num] = true;

		for (Node next: lists[num]) {
			if (!isVisited[next.vertex]) {
				distance[next.vertex] = distance[num] + next.distance;
				if (maxNode.distance < distance[next.vertex]) {
					maxNode.vertex = next.vertex;
					maxNode.distance = distance[next.vertex];
				}
				dfs(next.vertex);
			}
		}
	}

	private static class Node {
		int vertex; // 연결된 정점
		int distance; // 정점과의 거리

		private Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
}
