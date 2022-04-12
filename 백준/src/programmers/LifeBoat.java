package programmers;

import java.util.Arrays;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42885?language=java
 */
public class LifeBoat {

	class Solution {
		public int solution(int[] people, int limit) {

			Arrays.sort(people);

			int min = 0;
			int max = people.length - 1;
			int count = 0;

			while (min <= max) {
				if (people[min] + people[max] <= limit) {
					count++;
					min++;
					max--;
					continue;
				}
				max--;
				count++;
			}

			return count;
		}
	}
}
