package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1967
 */
public class Problem1967 {

	private static List<Node>[] lists;
	private static boolean[] isVisited;

	private static Node maxNode = new Node(0, 0);
	private static int[] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		int n = Integer.parseInt(bufferedReader.readLine());

		if (n == 1) {
			System.out.println(0);
			return;
		}

		lists = new ArrayList[n + 1];
		isVisited = new boolean[n + 1];
		weight = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int number = Integer.parseInt(stringTokenizer.nextToken());
			int vertex = Integer.parseInt(stringTokenizer.nextToken());
			int weight = Integer.parseInt(stringTokenizer.nextToken());

			lists[number].add(new Node(vertex, weight));
			lists[vertex].add(new Node(number, weight));
		}

		dfs(1);

		maxNode.weight = 0;
		weight = new int[n + 1];
		isVisited = new boolean[n + 1];
		dfs(maxNode.vertex);

		System.out.println(maxNode.weight);
	}

	private static void dfs(int num) {
		if (isVisited[num]) {
			return;
		}

		isVisited[num] = true;

		for (Node next: lists[num]) {
			if (!isVisited[next.vertex]) {
				weight[next.vertex] = weight[num] + next.weight;
				if (maxNode.weight < weight[next.vertex]) {
					maxNode.vertex = next.vertex;
					maxNode.weight = weight[next.vertex];
				}
				dfs(next.vertex);
			}
		}
	}

	private static class Node {
		int vertex; // 연결된 정점
		int weight; // 정점과의 거리

		private Node(int vertex, int distance) {
			this.vertex = vertex;
			this.weight = distance;
		}
	}
}
