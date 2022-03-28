package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {
	static class Solution {
		public int[] solution(int[] prices) {
			int[] ans = new int[prices.length];

			for (int i = 0; i < prices.length; i++) {
				for (int j = i + 1; j < prices.length; j++) {
					ans[i]++;
					if (prices[i] > prices[j])
						break;

				}
			}
			return ans;
		}
	}
}
