package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/68645?language=java
 */
public class TriangularSnail {
	static class Solution {
		public int[] solution(int n) {
			int[] answer = new int[n * (n + 1) / 2];
			int[][] mat= new int[n][n];

			int row = -1;
			int col = 0;
			int idx = 1;

			for(int i = 0; i < n; i++){
				for(int j = i; j < n; j++){
					if(i % 3 == 0){ //아래로
						row++;
					} else if(i % 3 == 1){//오른쪽으로
						col++;
					} else {//대각선으로
						row--;
						col--;
					}
					mat[row][col]= idx++;
				}
			}

			idx = 0;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(mat[i][j]==0) {
						break;
					}
					answer[idx++]= mat[i][j];
				}
			}
			return answer;
		}
	}
}
