package programmers;

import java.util.LinkedList;
import java.util.List;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/67257
 */
public class MaximizeFormula {
	public static void main(String[] args) {
		System.out.println(Solution.solution("50*6-3*2"));
		System.out.println(Solution.solution("100-200*300-500+20"));

	}

	static class Solution {

		private static String[][] order = {
				{"*" , "+", "-"},
				{"*" , "-", "+"},
				{"+" , "*", "-"},
				{"+" , "-", "*"},
				{"-" , "+", "*"},
				{"-" , "*", "+"}
		};

		private static List<Long> num;
		private static List<String> op;
		private static List<Long> tmpNum;
		private static List<String> tmpOp;

		public static long solution(String expression) {

			String[] tmp = expression.split("[*+-]");
			num = new LinkedList<>();
			for (int i = 0; i < tmp.length; i++) {
				num.add(Long.parseLong(tmp[i]));
			}

			tmp = expression.split("\\d{1,3}");
			op = new LinkedList<>();
			for (int i = 1; i < tmp.length; i++) {
				op.add(tmp[i]);
			}

			Long max = Long.MIN_VALUE;

			for (int i = 0; i < 6; i++) {

				tmpNum = new LinkedList<>();
				for (Long l : num) {
					tmpNum.add(l);
				}

				tmpOp = new LinkedList<>();
				for (String s : op) {
					tmpOp.add(s);
				}

				for (int j = 0; j < 3; j++) {
					for (int l = 0; l < tmpOp.size(); l++) {
						System.out.print(tmpNum.get(l)+tmpOp.get(l));
					}
					System.out.print(tmpNum.get(tmpNum.size() - 1));
					System.out.println();

					if ("+".equals(order[i][j])) {
						plus();
						continue;
					}

					if ("-".equals(order[i][j])) {
						minus();
						continue;
					}

					multiply();
				}

				max = Math.max(max, Math.abs(tmpNum.get(0)));
			}
			return max;
		}

		private static void plus() {

			for (int i = 0; i < tmpOp.size(); i++) {
				if ("+".equals(tmpOp.get(i))) {
					Long l = tmpNum.get(i) + tmpNum.get(i + 1);
					tmpNum.remove(i);
					tmpNum.remove(i);
					tmpOp.remove(i);
					tmpNum.add(i, l);
					i--;
				}
			}
		}

		private static void minus() {

			for (int i = 0; i < tmpOp.size(); i++) {
				if ("-".equals(tmpOp.get(i))) {
					Long l = tmpNum.get(i) - tmpNum.get(i + 1);
					tmpNum.remove(i);
					tmpNum.remove(i);
					tmpOp.remove(i);
					tmpNum.add(i, l);
					i--;
				}
			}
		}

		private static void multiply() {

			for (int i = 0; i < tmpOp.size(); i++) {
				if ("*".equals(tmpOp.get(i))) {
					Long l = tmpNum.get(i) * tmpNum.get(i + 1);
					tmpNum.remove(i);
					tmpNum.remove(i);
					tmpOp.remove(i);
					tmpNum.add(i, l);
					i--;
				}
			}
		}
	}
}
