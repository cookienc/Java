package programmers;

public class CaesarCipher {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String answer = solution.solution("AB", 1);
        System.out.println(answer);
    }

    static class Solution {
        public String solution(String s, int n) {
            final char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == ' ') {
                    continue;
                }

                if ('a' <= c && c <= 'z') {
                    final int diff = c - 'a';
                    final int newDiff = diff + n;

                    chars[i] = (char) ('a' + newDiff % 26);
                    continue;
                }

                final int diff = c - 'A';
                final int newDiff = diff + n;

                chars[i] = (char) ('A' + newDiff % 26);
            }

            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            return sb.toString();
        }
    }
}
