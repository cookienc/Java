package programmers;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookList {

	public static void main(String[] args) {
		String[] phone = {"119", "97674223", "1195524421"};
		String[] phone1 = {"123","456","789"};
		String[] phone2 = {"12","123","1235","567","88"};
		System.out.println(Solution.solution(phone));
		System.out.println(Solution.solution(phone1));
		System.out.println(Solution.solution(phone2));
	}
	private static class Solution {
		public static boolean solution(String[] phone_book) {

			Map<String, String> map = new HashMap<>();
			for (String p : phone_book) {
				map.put(p, p);
			}

			StringBuilder sb;
			for (String p : phone_book) {
				sb = new StringBuilder();
				for (int i = 0; i < p.length() - 1; i++) {
					sb.append(p.charAt(i));

					String key = sb.toString();
					if (map.containsKey(key)) {
						return false;
					}
				}
			}

			return true;
		}
	}
}
