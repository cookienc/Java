package programmers;

public class Network {
    static class Solution {

        private static boolean[] isVisited;

        public int solution(int n, int[][] computers) {
            int answer = 0;
            isVisited = new boolean[computers.length];
            for (int i = 0; i < computers.length; i++) {
                if (isVisited[i]) {
                    continue;
                }
                dfs(computers, i);
                answer++;
            }

            return answer;
        }

        private static void dfs(int[][] computers, int start) {
            isVisited[start] = true;

            for (int i = 0; i < computers.length; i++) {
                if (computers[start][i] == 0 || isVisited[i]) {
                    continue;
                }

                dfs(computers, i);
            }
        }
    }
}
