package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		List<Integer> list = new ArrayList<>();

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(stringTokenizer.nextToken()));
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < m; i++) {
			list.add(Integer.parseInt(stringTokenizer.nextToken()));
		}

		Collections.sort(list);

		for (int i : list) {
			stringBuilder.append(i)
					.append(" ");
		}

		System.out.println(stringBuilder);
	}
}
