package programmers;

import java.util.LinkedList;
import java.util.List;

public class NewIdRecommend {
	class Solution {
		public String solution(String new_id) {

			new_id = new_id.toLowerCase().replaceAll("[^0-9a-z\\-\\_\\.]", "");

			List<Character> list = new LinkedList<>();

			for (int i = 0; i < new_id.length(); i++) {
				list.add(new_id.charAt(i));
			}

			//3단계
			for (int i = 0; i < list.size() - 1; i++) {
				if ((list.get(i) == '.') && (list.get(i + 1) == '.')) {
					list.remove(i);
					i--;
					continue;
				}
			}

			if (list.get(0) == '.') {
				list.remove(0);
			}

			if (list.size() >= 1) {
				if (list.get(list.size() - 1) == '.') {
					list.remove(list.size() - 1);
				}
			}

			if (list.isEmpty()) {
				list.add('a');
			}

			if (list.size() >= 16) {
				list = list.subList(0, 15);
				if (list.get(14) == '.') {
					list.remove(14);
				}
			}

			if (list.size() <= 2) {
				char word = list.get(list.size() - 1);
				while (list.size() < 3) {
					list.add(word);
				}
			}

			StringBuilder sb = new StringBuilder();
			for (Character c : list) {
				sb.append(c);
			}

			return sb.toString();
		}
	}
}
