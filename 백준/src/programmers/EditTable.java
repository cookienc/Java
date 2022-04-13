package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EditTable {
	static class Solution {

		private static boolean[] isDeleted;
		private static List<Integer> list;
		private static int index;
		private static Stack<Command> previous;

		public String solution(int n, int k, String[] cmd) {

			isDeleted = new boolean[n];
			list = new ArrayList<>();
			index = k;
			previous = new Stack<>();
			Arrays.fill(isDeleted, false);

			for (int i = 0; i < n; i++) {
				list.add(i);
			}

			for (int i = 0; i < cmd.length; i++) {
				String[] word = cmd[i].split(" ");

				if ("D".equals(word[0])) {
					index += Integer.parseInt(word[1]);
					continue;
				}

				if ("U".equals(word[0])) {
					index -= Integer.parseInt(word[1]);
					continue;
				}

				if ("C".equals(word[0])) {
					previous.push(new Command(index, list.get(index)));
					list.remove(index);

					if (index == list.size()) {
						index = list.size() - 1;
					}
					continue;
				}

				//Z일경우
				Command p = previous.pop();

				if (p.index <= index) {
					index++;
				}

				list.add(p.index, p.value);
			}

			for (Integer i : list) {
				isDeleted[i] = true;
			}

			StringBuilder sb = new StringBuilder();
			for (boolean b : isDeleted) {
				if (b) {
					sb.append("O");
					continue;
				}
				sb.append("X");
			}

			return sb.toString();
		}

		private static class Command {

			int index;
			int value;

			public Command(int index, int value) {
				this.index = index;
				this.value = value;
			}
		}
	}
}
