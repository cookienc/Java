package programmers;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(Solution.solution("aabbaccc"));
		System.out.println(Solution.solution("ababcdcdababcdcd"));
		System.out.println(Solution.solution("abcabcdede"));
		System.out.println(Solution.solution("abcabcabcabcdededededede"));
		System.out.println(Solution.solution("xababcdcdababcdcd"));
	}

	static class Solution {
		public static int solution(String s) {
			int answer = s.length();
			int len = s.length();

			if (s.length() == 1) {
				return 1;
			}
			
			for (int size = 1; size <= len / 2; size++) {
				
				String pattern = s.substring(0, size);
				
				int compLen = 0;
				int cnt = 1;
				
				for (int start = size; start + size <= s.length(); start += size) {

					String target = s.substring(start, start + size);
					if (pattern.equals(target)) { // 같으면
						cnt++;
					} else { //같지 않으면
						if (cnt > 1) { //앞에서 일치했을 경우
							compLen += (int) Math.log10(cnt) + 1; //자리수
						}
						pattern = target;
						compLen += pattern.length();
						cnt = 1;
					}
				}

				if (cnt > 1) {
					compLen += (int) Math.log10(cnt) + 1;
				}

				int div = s.length() % size;
				if (div > 0) {
					compLen += div;
				}
				compLen += pattern.length();

				answer = Math.min(answer, compLen);
			}

			return answer;
		}
	}
}
