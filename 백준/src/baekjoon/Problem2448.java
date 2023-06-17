package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2448 {
    private static char[][] answers;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        answers = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(answers[i], ' ');
        }

        star(N, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(answers[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int size, int r, int c) {
        if (size == 3) {
            createStar(r, c);
            return;
        }

        int resize = size / 2;
        star(resize, r, c);
        star(resize, r + resize, c - resize);
        star(resize, r + resize, c + resize);
    }

    private static void createStar(final int r, final int c) {
        answers[r][c] = '*';
        answers[r + 1][c - 1] = '*';
        answers[r + 1][c + 1] = '*';
        answers[r + 2][c - 2] = '*';
        answers[r + 2][c - 1] = '*';
        answers[r + 2][c] = '*';
        answers[r + 2][c + 1] = '*';
        answers[r + 2][c + 2] = '*';
    }
}
