package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/1845?language=java
 */
public class Ponkemon {
	static class Solution {
		public int solution(int[] nums) {

			Set<Integer> set = new HashSet<>();

			for (int i : nums) {
				set.add(i);
			}
			return set.size() >= nums.length / 2? nums.length / 2 : set.size();
		}
	}
}
