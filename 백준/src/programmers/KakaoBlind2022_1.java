package programmers;

import java.util.*;

public class KakaoBlind2022_1 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int[] answer = solution(id_list, report, 2);

		for (int i : answer) {
			System.out.println(i);
		}

	}

	public static int[] solution(String[] id_list, String[] report, int k) {

		//나올 수 없는 경우
		if (k >= id_list.length) {
			return new int[id_list.length];
		}

		report = Arrays.stream(report)
				.distinct()
				.toArray(String[]::new);

		Map<String, Integer> answer = new LinkedHashMap<>();
		Map<String, List<String>> reportMap = new HashMap<>();

		//초기화
		for (int i = 0; i < id_list.length; i++) {
			answer.put(id_list[i], 0);
			List<String> sample = new ArrayList<>();
			reportMap.put(id_list[i], sample);
		}

		//저장
		for (int i = 0; i < report.length; i++) {
			String[] word = report[i].split(" ");
			String id = word[0];
			String reportId = word[1];

			reportMap.get(reportId).add(id);
		}

		// 찾기
		for (String key : reportMap.keySet()) {
			if (reportMap.get(key).size() >= k) { // 신고 횟수가 초과이면
				for (String id : reportMap.get(key)) {
					answer.merge(id, 1, Integer::sum);
				}
			}
		}

		return answer.values().stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}
}
