package codeup;

import java.io.*;

public class Problem1098 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = bufferedReader.readLine().split(" ");

        int[][] pan = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        int count = Integer.parseInt(bufferedReader.readLine());

        if(count != 0) {
            for (int i = 0; i < count; i++) {
                String[] info = bufferedReader.readLine().split(" ");

                int length = Integer.parseInt(info[0]);
                int direction = Integer.parseInt(info[1]);
                int x = Integer.parseInt(info[2]);
                int y = Integer.parseInt(info[3]);

                putStick(pan, length, direction, x, y);
            }
        }

        for (int[] a : pan) {
            for(int b : a) {
                bufferedWriter.write(b + " ");
            }
            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();
    }

    private static void putStick(int[][] pan, int length, int direction, int x, int y) {
        // 1. 방향 판별 direction == 0 가로로, direction == 1 이면 세로로
        // 2. 주어진 x y좌표에서 시작
        // 3. lenght만큼 반복

        if (direction == 0) {

            for (int i = 0; i < length; i++) {
                pan[x - 1][y - 1 + i] = 1;
            }

        } else {

            for (int i = 0; i < length; i++) {
                pan[x - 1 + i][y - 1] = 1;
            }

        }
    }
}
