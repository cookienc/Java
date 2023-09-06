package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BadUser {

    public static void main(String[] args) {
        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId = {"fr*d*", "*rodo", "******", "******"};
        final Solution solution = new Solution();
        System.out.println(solution.solution(userId, bannedId));
    }

    private static class Solution {

        private static Set<Integer> answers = new HashSet<>();
        private static String[] userIds;
        private static List<Pattern> patterns;

        public int solution(String[] user_id, String[] banned_id) {
            userIds = user_id;

            patterns = Arrays.stream(banned_id)
                    .map(regex -> regex.replaceAll("\\*", "."))
                    .map(Pattern::compile)
                    .collect(Collectors.toList());

            dfs(0, 0);

            return answers.size();
        }

        private void dfs(int userVisited, final int depth) {
            if (depth == patterns.size() ) {
                if (Integer.bitCount(userVisited) == depth) {
                    answers.add(userVisited);
                }
                return;
            }

            for (int i = 0; i < userIds.length; i++) {
                if (patterns.get(depth).matcher(userIds[i]).matches()) {
                    int updatedUserVistied = userVisited;
                    updatedUserVistied |= (1 << i);

                    dfs(updatedUserVistied, depth + 1);
                }
            }
        }
    }
}
