package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1966
 */
public class Problem1966 {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		final StringBuilder answer = new StringBuilder();
		while (T-- > 0) {
			int cnt = 1;

			StringTokenizer st = new StringTokenizer(br.readLine());
			final int N = Integer.parseInt(st.nextToken());
			final int targetName = Integer.parseInt(st.nextToken());

			final Queue<Document> q = new LinkedList<>();
			int[] primarities = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				final int primary = Integer.parseInt(st.nextToken());
				primarities[primary]++;
				q.add(new Document(primary, i));
			}

			while (!q.isEmpty()) {
				final Document cur = q.poll();
				final int maxPrimary = findMaxPrimary(primarities);
				if (cur.primary < maxPrimary) {
					q.offer(cur);
					continue;
				}

				if (cur.primary == maxPrimary) {
					primarities[maxPrimary]--;

					if (cur.name == targetName) {
						answer.append(cnt).append(System.lineSeparator());
						break;
					}

					cnt++;
				}
			}
		}

		System.out.println(answer);
	}

	private static int findMaxPrimary(int[] primarites) {
		for (int i = primarites.length - 1; i >= 0; i--) {
			if (primarites[i] != 0) {
				return i;
			}
		}
		return -1;
	}

	private static class Document {

		int primary;
		int name;

		public Document(final int primary, final int name) {
			this.primary = primary;
			this.name = name;
		}
	}
}
