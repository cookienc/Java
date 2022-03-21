package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TakeAPicture {

	public static void main(String[] args) {
		System.out.println(Solution.solution(3, new String[]{"N~A=0", "R~T>2", "A~C=0"}));
		System.out.println(Solution.solution(5, new String[]{"N~A=0", "R~T>2", "A~C=0", "J~N<4", "F~R=2"}));
		System.out.println(Solution.solution(4, new String[]{"F~J=6", "M~N=4", "R~T=2", "T~J=0"}));
	}

	static class Solution {

		private static int count = 0;
		private static String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
		private static List<Condition> condition;
		private static String[] temp;
		private static boolean[] isVisited;

		public static int solution(int n, String[] data) {
			StringTokenizer st;
			condition = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(data[i], "~=<>", true);
				String memberA = st.nextToken();
				String tilde = st.nextToken();
				String memberB = st.nextToken();
				String op = st.nextToken();
				int distance = Integer.parseInt(st.nextToken());
				condition.add(new Condition(memberA, memberB, op, distance));
			}
			temp = new String[8];
			isVisited = new boolean[8];
			count = 0;
			dfs(0);

			return count;
		}

		private static void dfs(int depth) {

			if (depth == 8) {
				if (check(temp)) {
					count++;
				}
				return;
			}

			for (int i = 0; i < 8; i++) {
				if(!isVisited[i]) {
					isVisited[i] = true;
					temp[depth] = members[i];
					dfs(depth + 1);
					isVisited[i] = false;
				}
			}

		}

		private static boolean check(String[] arr) {
			for (Condition c : condition) {

				int a = findIndex(arr, c.memberA);
				int b = findIndex(arr, c.memberB);

				int distance = Math.abs(a - b) - 1;

				if (c.op.equals("=")) {
					if (!(distance == c.distance)) {
						return false;
					}
					continue;
				}

				if (c.op.equals(">")) {
					if (!(distance > c.distance)) {
						return false;
					}
					continue;
				}

				if (c.op.equals("<")) {
					if (!(distance < c.distance)) {
						return false;
					}
					continue;
				}
			}
			return true;
		}

		private static int findIndex(String[] arr, String value) {
			int i = 0;
			for (i = 0; i < arr.length; i++) {
				if (arr[i].equals(value)) {
					return i;
				}
			}
			return -999999;
		}

		private static class Condition {
			public String memberA;
			public String memberB;
			public String op;
			public int distance;

			public Condition(String memberA, String memberB, String op, int distance) {
				this.memberA = memberA;
				this.memberB = memberB;
				this.op = op;
				this.distance = distance;
			}
		}
	}
}
