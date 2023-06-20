package programmers;

public class StringHandlingBasics {

    static class Solution {

        public boolean solution(String s) {
            int length = s.length();
            if (length != 4 && length != 6) {
                return false;
            }

            for (int i = 0; i < length; i++) {
                char word = s.charAt(i);
                if (word < '0' || '9' < word) {
                    return false;
                }
            }

            return true;
        }
    }
}
