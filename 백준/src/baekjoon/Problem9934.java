package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9934
 */
public class Problem9934 {
	
	private static int N;
	private static int[] arr;
	private static List<List<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		N = (int) Math.pow(2, K) - 1;

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
		}

		list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			list.add(new ArrayList<>());
		}

		makeTree(0, N - 1, 0);

		StringBuilder sb = new StringBuilder();
		for (List<Integer> integers : list) {
			for (Integer i : integers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void makeTree(int start, int end, int depth) {

		if (start == end) {
			list.get(depth).add(arr[start]);
			return;
		}
		
		int mid = (start + end) / 2;

		list.get(depth).add(arr[mid]);
		makeTree(start, mid - 1, depth + 1);
		makeTree(mid + 1, end, depth + 1);
	}
}
