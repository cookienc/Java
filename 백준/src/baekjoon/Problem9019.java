package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9019
 * 참고: https://girawhale.tistory.com/15
 */
public class Problem9019 {

	public static final int MAX_SIZE = 10_000;
	public static final String NEW_LINE = "\n";
	private static boolean[] isVisited;
	private static Queue<Register> queue;
	private static final StringBuilder sb = new StringBuilder();
	private static int B;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			isVisited = new boolean[MAX_SIZE];
			queue = new LinkedList<>();

			isVisited[A] = true;

			queue.add(new Register(A, ""));

			bfs(A);
		}

		System.out.println(sb);
	}

	private static void bfs(int num) {

		while (!queue.isEmpty()) {
			Register register = queue.poll();

			if (register.number == B) {
				sb.append(register.command)
						.append(NEW_LINE);
				break;
			}

			if (!isVisited[register.D()]) {
				isVisited[register.D()] = true;
				queue.add(new Register(register.D(), register.command + "D"));
			}

			if (!isVisited[register.S()]) {
				isVisited[register.S()] = true;
				queue.add(new Register(register.S(), register.command + "S"));
			}

			if (!isVisited[register.L()]) {
				isVisited[register.L()] = true;
				queue.add(new Register(register.L(), register.command + "L"));
			}

			if (!isVisited[register.R()]) {
				isVisited[register.R()] = true;
				queue.add(new Register(register.R(), register.command + "R"));
			}
		}
	}

	private static class Register {
		int number;
		String command;

		public Register(int number, String command) {
			this.number = number;
			this.command = command;
		}

		private int D() {
			return this.number * 2 % MAX_SIZE;
		}

		private int S() {
			return this.number == 0? 9999 : this.number - 1;
		}

		private int L() {
			return this.number % 1000 * 10 + number / 1000;
		}

		private int R() {
			return this.number / 10 + this.number % 10 * 1000;
		}
	}
}
