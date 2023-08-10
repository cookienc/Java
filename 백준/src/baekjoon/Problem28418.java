package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem28418 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());
        final int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int d = Integer.parseInt(st.nextToken());
        final int f = Integer.parseInt(st.nextToken());

        int[] p = new int[3];
        p[0] = a * (int) Math.pow(d, 2);
        p[1] = 2 * a * d * f + b * d;
        p[2] = a * (int) Math.pow(f, 2) + b * f + c;

        int[] q = new int[3];
        q[0] = a * d;
        q[1] = b * d;
        q[2] = c * d + f;

        final int A = p[0] - q[0];
        final int B = p[1] - q[1];
        final int C = p[2] - q[2];

        if (A == 0 && B == 0 && C == 0) {
            System.out.println("Nice");
            return;
        }

        if (A == 0 && B == 0) {
            System.out.println("Head on");
            return;
        }

        if (A == 0 && B != C) {
            System.out.println("Remember my character");
            return;
        }

        if (A == 0 && B == C) {
            System.out.println("Head on");
            return;
        }

        final int judge = (int) Math.pow(B, 2) - 4 * A * C;

        if (judge < 0) {
            System.out.println("Head on");
            return;
        }

        if (judge > 1) {
            System.out.println("Go ahead");
            return;
        }

        System.out.println("Remember my character");
    }
}
