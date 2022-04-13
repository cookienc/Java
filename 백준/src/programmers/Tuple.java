package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Tuple {
	class Solution {
		public int[] solution(String s) {
			s = s.replaceAll("[{]{2}", "");
			s = s.replaceAll("[}]{2}", "");

			if (Pattern.matches("[0-9]{1,}", s)) {
				return new int[]{Integer.parseInt(s)};
			}

			String[] word = s.split("[}]+[,]+[{]");
			Arrays.sort(word, (w1, w2) -> w1.length() - w2.length());

			List<String> list = new LinkedList<>();
			for (int i = 0; i < word.length; i++) {
				String[] str = word[i].split(",");

				for (String st : str) {
					if (!list.contains(st)) {
						list.add(st);
					}
				}
			}

			return list.stream()
					.mapToInt(a -> Integer.parseInt(a))
					.toArray();
		}
	}
}
