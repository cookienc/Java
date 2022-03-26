package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FailureProbability {
	static class Solution {
		public int[] solution(int N, int[] stages) {
			int[] step = new int[N + 2];
			int[] passMember = new int[N + 2];

			for (int i : stages) {

				step[i]++;

				for (int j = 1; j <= i; j++) {
					passMember[j]++;
				}
			}

			List<Node> list = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (passMember[i] == 0) {
					list.add(new Node(i, (double) 0));
					continue;
				}

				list.add(new Node(i, (double) step[i] / passMember[i]));
			}

			return list.stream()
					.sorted(Comparator.comparing(Node::getProbability)
							.reversed()
							.thenComparing(Node::getIndex))
					.mapToInt(n -> n.getIndex())
					.toArray();
		}

		public static class Node {
			public int index;
			public double probability;

			public Node(int index, double probability) {
				this.index = index;
				this.probability = probability;
			}

			public int getIndex() {
				return this.index;
			}

			public double getProbability() {
				return this.probability;
			}
		}
	}
}
