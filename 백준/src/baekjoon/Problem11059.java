package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11059 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] charArray = br.readLine().toCharArray();

        final int length = charArray.length;
        final int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = charArray[i] - '0';
        }

        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }

        int answer = 0;
        for (int l = 0; l <= length / 2; l++) {
            for (int i = 0; i < length; i++) {
                final int j = i + l +1;
                if (j + l >= length) {
                    continue;
                }

                if (i == 0) {
                    if ((arr[i + l]) == (arr[j + l] - arr[j - 1])) {
                        answer = Math.max(answer, 2 * (l + 1));
                    }
                    continue;
                }

                if ((arr[i + l] - arr[i - 1]) == (arr[j + l] - arr[j - 1])) {
                    answer = Math.max(answer, 2 * (l + 1));
                }
            }
        }
        System.out.println(answer);
    }
}
