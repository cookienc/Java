package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 출: https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class AthletesWhoDidNotFinish {
	private static class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = "";

			//참가자 저장
			Map<String, Integer> map = new HashMap<>();
			for(String p : participant) {
				map.merge(p, 1, Integer::sum);
			}

			//참가자 명단을 지워가며 선택
			for(String c : completion) {
				map.merge(c, 0, (cnt1, cnt2) -> cnt1 - 1);
			}

			return map.entrySet().stream()
					.filter(m -> m.getValue() == 1)
					.map(Map.Entry::getKey)
					.findFirst().get();
		}
	}
}
