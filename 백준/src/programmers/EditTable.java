package programmers;

import java.util.Stack;

public class EditTable {
	static class Solution {

		private static Stack<Integer> previous;

		public String solution(int n, int k, String[] cmd) {

			previous = new Stack<>();
			int size = n;

			for (String c : cmd) {
				String[] word = c.split(" ");

				if ("D".equals(word[0])) {
					k += Integer.parseInt(word[1]);
					continue;
				}

				if ("U".equals(word[0])) {
					k -= Integer.parseInt(word[1]);
					continue;
				}

				if ("C".equals(word[0])) {
					previous.push(k);

					if (k == size - 1) {
						k = size - 2;
					}
					size--;
					continue;
				}

				//Z일경우
				Integer i = previous.pop();

				if (i <= k) {
					k++;
				}
				size++;
			}

			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < size; i++) {
				sb.append('O');
			}
			while(!previous.isEmpty()) {
				sb.insert(previous.pop().intValue(), 'X');
			}
			return sb.toString();
		}
	}
}
