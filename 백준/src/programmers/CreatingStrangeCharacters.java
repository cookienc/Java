package programmers;

public class CreatingStrangeCharacters {
    static class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();

            int wordIdx = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    wordIdx = 0;
                    sb.append(' ');
                    continue;
                }

                if (wordIdx % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                    wordIdx++;
                    continue;
                }

                sb.append(Character.toLowerCase(c));
                wordIdx++;
            }

            return sb.toString();
        }
    }
}
