package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2331 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int a = Integer.parseInt(stringTokenizer.nextToken());
		int p = Integer.parseInt(stringTokenizer.nextToken());
		int answer = 0;

		List<Integer> list = new ArrayList<>();
		list.add(a);

		while (true) {

			int temp = list.get(list.size() - 1);

			int result = 0;

			while (temp != 0) {
				result += (int) Math.pow(temp % 10, (double) p);
				temp /= 10;
			}

			if (list.contains(result)) {
				answer = list.indexOf(result);
				break;
			}

			list.add(result);
		}

		System.out.println(answer);
	}
}
