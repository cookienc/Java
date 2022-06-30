package programmers;

import java.util.*;

import static java.util.Comparator.*;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12978
 */
public class Delivery {

	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		System.out.println(new Solution().solution(N, road, 3));
	}

	static class Solution {
		
		private static int[] d;
		private static List<List<Node>> distance;
		private static final int INF = 500_001;
		
		public int solution(int N, int[][] road, int K) {

			d = new int[N];
			distance = new ArrayList<>();
			initializeDis(N, road);
			
			dijkstra();

			return (int) Arrays.stream(d)
					.filter(d -> d <= K)
					.count();
		}

		private void dijkstra() {
			Arrays.fill(d, INF);
			d[0] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>(comparingInt(n -> n.weight));
			pq.add(new Node(0, 0));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				int curIdx = cur.v;
				int curWeight = cur.weight;

				if (d[curIdx] < curWeight) {
					continue;
				}

				for (Node next : distance.get(curIdx)) {
					int nextIdx = next.v;
					int nextWeight = next.weight;

					if (nextWeight + curWeight < d[nextIdx]) {
						d[nextIdx] = nextWeight + curWeight;
						pq.add(new Node(nextIdx, d[nextIdx]));
					}
				}
			}
		}

		private void initializeDis(int N, int[][] road) {
			for (int i = 0; i < N; i++) {
				distance.add(new ArrayList<>());
			}

			for (int[] r : road) {
				int from = r[0] - 1;
				int to = r[1] - 1;
				int weight = r[2];

				distance.get(from).add(new Node(to, weight));
				distance.get(to).add(new Node(from, weight));
			}
		}
	}
	
	private static class Node {
		int v;
		int weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
}
