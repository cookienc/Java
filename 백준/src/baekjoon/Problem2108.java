package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * 출처: https://www.acmicpc.net/problem/2108
 */
public class Problem2108 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] array = new int[8002][2]; // 0 -> -4000 ~ 0 : 0 4001, 1 -> 1 ~ 4000 : 4002 8001
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int no = Integer.parseInt(bf.readLine());
			list.add(no);

			array[no + 4000][0] = no;
			array[no + 4000][1]++;
		}
		//평균값
		OptionalDouble average = list.stream()
				.mapToInt(Integer::new)
				.average();
		long round = Math.round(average.getAsDouble());

		list.sort(Integer::compareTo);

		//중간값
		Integer mid = list.get(list.size() / 2);

		//최빈값
		int value = array[0][0];
		int count = array[0][1];

		for (int i = 1; i < 8002; i++) {
			if (array[i][1] == 0) {
				continue;
			}

			if (array[i][1] > count) {
				value = array[i][0];
				count = array[i][1];
			}
		}
		int max = count;

		List<Integer> frequencyList = Arrays.stream(array)
				.filter(a -> a[1] == max)
				.map(b -> b[0])
				.collect(Collectors.toList());

		frequencyList.sort(Integer::compareTo);
		if (frequencyList.size() != 1) {
			value = frequencyList.get(1);
		} else {
			value = frequencyList.get(0);
		}

		//범위
		Integer first = list.get(0);
		Integer last = list.get(list.size() - 1);
		int range = last - first;

		System.out.println(round);
		System.out.println(mid);
		System.out.println(value);
		System.out.println(range);
	}
}