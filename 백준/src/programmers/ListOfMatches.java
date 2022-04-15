package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12985
 */
public class ListOfMatches {
	static class Solution {
		public int solution(int n, int a, int b) {

			int count = 1;
			while (true) {

				// if 옆이면 나감
				if (Math.abs(a - b) == 1) {
					if (a > b) {
						if (a % 2 == 0) {
							break;
						}
					} else {
						if (b % 2 == 0) {
							break;
						}
					}
				}

				count++;
				a = nextNum(a);
				b = nextNum(b);
			}
			return count;
		}

		private static int nextNum(int num) {
			if (num % 2 == 0) {
				return num / 2;
			}

			return (num + 1) / 2;
		}
	}
}
