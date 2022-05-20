package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/2252
 */
public class Problem2252 {

	public static final String SPACE = " ";
	private static List<List<Integer>> list;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new LinkedList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new LinkedList<>());
		}

		int[] member = new int[N + 1];
		Arrays.fill(member, 0);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int member1 = Integer.parseInt(st.nextToken());
			int member2 = Integer.parseInt(st.nextToken());
			member[member2]++;
			list.get(member1).add(member2);
		}

		lining(N, member);
		System.out.println(sb);
	}

	private static void lining(int N, int[] member) {
		Queue<Integer> queue = new LinkedList<>();
		findMember(N, member, queue);

		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			sb.append(cur).append(SPACE);
			for (Integer index : list.get(cur)) {
				member[index]--;
				if (member[index] == 0) {
					queue.add(index);
				}
			}
		}
	}

	private static void findMember(int N, int[] member, Queue<Integer> queue) {
		for (int i = 1; i <= N; i++) {
			if (member[i] == 0) {
				member[i]--;
				queue.add(i);
			}
		}
	}
}
