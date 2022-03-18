package programmers;

import java.util.*;

public class OpenKakao {
	class Solution {
		private static final String ENTER = "Enter";
		private static final String LEAVE = "Leave";
		private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
		private static final String LEAVE_MESSAGE = "님이 나갔습니다.";

		public String[] solution(String[] record) {
			List<String> list = new ArrayList<>();
			Map<String, String> status = new HashMap<>();
			Queue<String> message = new LinkedList<>();

			for (String r : record) {
				String[] word = r.split(" ");

				if (word[0].equals(ENTER)) {
					list.add(word[1]);
					message.offer(ENTER_MESSAGE);
					status.merge(word[1], word[2], (name1, name2) -> name2);
					continue;
				}

				if (word[0].equals(LEAVE)) {
					list.add(word[1]);
					message.offer(LEAVE_MESSAGE);
					continue;
				}

				status.put(word[1], word[2]);
			}


			List<String> answer = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				answer.add(status.get(list.get(i)) + message.poll());
			}

			return answer.stream()
					.toArray(String[]::new);
		}
	}
}
