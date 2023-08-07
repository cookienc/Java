package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2493
 */
public class Problem2493 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final Deque<Tower> stack = new ArrayDeque<>();
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            final Tower current = new Tower(i, Integer.parseInt(st.nextToken()));

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.addLast(current);
                continue;
            }

            while (true) {
                final Tower lastTower = stack.peekLast();
                if (stack.isEmpty()) {
                    break;
                }
                if (lastTower.height < current.height) {
                    stack.removeLast();
                    continue;
                }
                break;
            }

            if (stack.isEmpty()) {
				sb.append(0).append(" ");
            } else {
                sb.append(stack.peekLast().index).append(" ");
            }
            stack.addLast(current);
        }

        System.out.println(sb);
    }

    private static class Tower {
        int index;
        int height;

        public Tower(final int index, final int height) {
            this.index = index;
            this.height = height;
        }
    }
}
