package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 출처: https://www.acmicpc.net/problem/18258
 */
public class Problem18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		List<String> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] str = s.split(" ");
			String command = str[0];

			if (command.equals("push")) {
				queue.add(str[1]);
				continue;
			}

			if (command.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(queue.remove(0)).append("\n");
				continue;
			}

			if (command.equals("front")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(queue.get(0)).append("\n");
				continue;
			}

			if (command.equals("back")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(queue.get(queue.size() - 1)).append("\n");
				continue;
			}

			if (command.equals("size")) {
				sb.append(queue.size()).append("\n");
				continue;
			}

			if (command.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
