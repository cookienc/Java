package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem10994 {

    private static char[][] answers;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int length = 4 * N - 3;
        answers = new char[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(answers[i], ' ');
        }

        int row = 0;
        int col = 0;
        for (int i = N; i >= 2; i--) {
            createStar(i, row, col);
            row += 2;
            col += 2;
        }
        answers[2 * (N - 1)][2 * (N - 1)] = '*';

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < answers.length; r++) {
            for (int c = 0; c < answers[r].length; c++) {
                sb.append(answers[r][c]);
            }
            sb.append(System.lineSeparator());
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void createStar(final int N, final int r, final int c) {
        int length = 4 * N - 3;

        for (int col = c; col < c + length; col++) {
            answers[r][col] = '*';
            answers[r + length - 1][col] = '*';
        }

        for (int row = r; row < r + length; row++) {
            answers[row][c] = '*';
            answers[row][c + length - 1] = '*';
        }
    }
}
