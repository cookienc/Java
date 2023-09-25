package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/16171
 */
public class Problem16171 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String S = br.readLine();
        final String answer = br.readLine();

        final char[] word = S.toCharArray();
        final char[] answerWord = answer.toCharArray();

        boolean found = false;
        for (int i = 0; i < word.length; i++) {
            if (word[i] != answerWord[0]) {
                continue;
            }

            int idx = 1;
            for (int j = i + 1; j < word.length; j++) {
                if (idx >= answerWord.length) {
                    break;
                }

                final char cur = word[j];
                if (isNumber(cur)) {
                    continue;
                }

                if (cur != answerWord[idx]) {
                    break;
                }

                idx++;
            }

            if (idx == answerWord.length) {
                found = true;
                break;
            }
        }

        System.out.println(found ? 1 : 0);
    }

    private static boolean isNumber(final char word) {
        return '0' <= word && word <= '9';
    }
}
