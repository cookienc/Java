package codeup;

import java.io.*;

public class Problem1097 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] pan = new String[19][19];

        for (int i = 0; i < pan.length; i++) {
            pan[i] = bufferedReader.readLine().split(" ");
        }

        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++) {
            String[] position = bufferedReader.readLine().split(" ");
            flipPan(Integer.parseInt(position[0]), Integer.parseInt(position[1]), pan);
        }

        for (String[] strings : pan) {
            for (String str : strings) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static void flipPan(int x, int y, String[][] pan) {

        //x좌표 뒤집기
        for (int i = 0; i < pan[x-1].length; i++) {
            if (pan[x-1][i].equals("1")) {
                pan[x-1][i] = "0";
            } else {
                pan[x-1][i] = "1";
            }
        }

        //y좌표 뒤집기
        for (int i = 0; i < pan.length; i++) {
            if (pan[i][y-1].equals("1")) {
                pan[i][y-1] = "0";
            } else {
                pan[i][y-1] = "1";
            }
        }

    }
}
