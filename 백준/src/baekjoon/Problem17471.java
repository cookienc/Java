package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/17471
 * 참고: https://hyewon-study-log.tistory.com/125?category=976036
 */
public class Problem17471 {

	private static int N;
	private static int[] population;
	private static int[] areaA;
	private static int[] areaB;
	private static boolean[] isSelected;
	private static List<List<Integer>> adjList;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int adjCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < adjCnt; j++) {
				adjList.get(i + 1).add(Integer.parseInt(st.nextToken()));
			}
		}
		ans = Integer.MAX_VALUE;
		solve(1 << N);
		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		System.out.println(ans);

	}

	private static void solve(int bit) {
		List<Integer> groupA = new ArrayList<Integer>();
		List<Integer> groupB = new ArrayList<Integer>();
		for (int i = 0; i < bit; i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					groupA.add(j + 1);
				} else {
					groupB.add(j + 1);
				}
			}

			if (groupA.size() > 0 && groupB.size() > 0) {
				//나눈 그룹들 각각 내부에서 연결되있는지 체크
				if (isConnect(groupA) && isConnect(groupB)) {
					ans = Math.min(ans, diffCount(groupA, groupB));
				}
			}

			groupA.clear();
			groupB.clear();
		}

	}

	private static int diffCount(List<Integer> groupA, List<Integer> groupB) {
		int sumA = 0, sumB = 0;
		for (int i = 0; i < groupA.size(); i++) {
			sumA += population[groupA.get(i) - 1];
		}
		for (int i = 0; i < groupB.size(); i++) {
			sumB += population[groupB.get(i) - 1];
		}
		return Math.abs(sumA - sumB);
	}

	private static boolean isConnect(List<Integer> group) {
		if (group.size() == 1) {
			return true;
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[N + 1];

		queue.add(group.get(0));
		isVisited[group.get(0)] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int now = queue.poll();
				for (int i = 0; i < adjList.get(now).size(); i++) {
					int next = adjList.get(now).get(i);

					if (!isVisited[next] && isNext(next, group)) {
						isVisited[next] = true;
						queue.add(next);
					}
				}
			}
		}

		//vistied 조사
		int visitCnt = 0;
		for (int i = 0; i <= N; i++) {
			if (isVisited[i]) visitCnt++;
		}
		return visitCnt == group.size() ? true : false;
	}

	//다음 방문 노드가 group에 있는 원소인지 확인
	private static boolean isNext(int next, List<Integer> group) {
		boolean flag = false;
		for (int i = 0; i < group.size(); i++) {
			if (group.get(i) == next) {
				flag = true;
			}
		}
		return flag;
	}
}