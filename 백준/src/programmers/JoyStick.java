package programmers;

import java.util.Arrays;

public class JoyStick {
	static class Solution {
		public int solution(String name) {
			int answer = 0;
			int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수

			for(int cur = 0; cur < name.length(); cur++) {
				answer += Math.min(name.charAt(cur) - 'A', 'Z' - name.charAt(cur) + 1);

				if (cur < move && name.charAt(cur + 1) == 'A') {
					int endA = cur + 1;
					while(endA < name.length() && name.charAt(endA) == 'A')
						endA++;
					move = Math.min(move, cur * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
					move = Math.min(move, cur + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
				}
			}
			return answer + move;
		}
	}
}
