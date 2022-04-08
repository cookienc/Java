package programmers;

import java.util.Arrays;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42746?language=java#
 */
public class TheLargestNumber {
	public String solution(int[] numbers) {

		String[] result = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			result[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(result, (a, b) -> (b + a).compareTo(a + b));

		if(result[0].equals("0")) {
			return "0";
		}

		StringBuilder answer = new StringBuilder();

		for (String a : result) {
			answer.append(a);
		}
		return answer.toString();
	}
}

