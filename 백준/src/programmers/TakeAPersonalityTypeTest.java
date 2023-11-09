package programmers;

import java.util.HashMap;
import java.util.Map;

public class TakeAPersonalityTypeTest {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        System.out.println(solution.solution(survey, choices));
    }

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            final Map<Character, Integer> results = new HashMap<>();
            results.put('R', 0);
            results.put('T', 0);
            results.put('C', 0);
            results.put('F', 0);
            results.put('J', 0);
            results.put('M', 0);
            results.put('A', 0);
            results.put('N', 0);

            for (int i = 0; i < survey.length; i++) {
                final char first = survey[i].charAt(0);
                final char second = survey[i].charAt(1);

                final int value = choices[i];

                if (value < 4) {
                    results.merge(first, 4 - value, Integer::sum);
                    continue;
                }

                if (value > 4) {
                    results.merge(second, value - 4, Integer::sum);
                }
            }

            final StringBuilder sb = new StringBuilder();
            sb.append(results.get('R') >= results.get('T') ? 'R' : 'T');
            sb.append(results.get('C') >= results.get('F') ? 'C' : 'F');
            sb.append(results.get('J') >= results.get('M') ? 'J' : 'M');
            sb.append(results.get('A') >= results.get('N') ? 'A' : 'N');

            return sb.toString();
        }
    }
}
