package codeup;

import java.io.*;
import java.util.Scanner;

public class Problem1084 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");

        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        int count = 0;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < c; k++) {
                    bufferedWriter.write(i + " " + j + " " + k + "\n");
                    count++;
                }
            }
        }
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
