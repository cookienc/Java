package codeup;

import java.io.*;
import java.lang.String;

public class Problem1096 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(bufferedReader.readLine());

        int[][] omok = new int[19][19];

        String[] position = new String[number];

        for (int i = 0; i < number; i++) {
            position[i] = String.valueOf(bufferedReader.readLine());
            String[] sit = position[i].split(" ");
            omok[Integer.parseInt(sit[0]) - 1][Integer.parseInt(sit[1]) - 1] = 1;
        }

        for (int i = 0; i < omok.length; i++) {
            for (int j = 0; j < omok[0].length; j++) {
                bufferedWriter.write(omok[i][j] + " ");
            }
            bufferedWriter.write("\n");
        }
                bufferedWriter.flush();
    }
}