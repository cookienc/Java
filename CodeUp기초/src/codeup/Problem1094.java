package codeup;

import java.io.*;

public class Problem1094 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");
        String[] str2 = bufferedReader.readLine().split(" ");

        int num = Integer.parseInt(str[0]);

        int[] a = new int[num];

        for (int i = 0; i < num; i++) {
            a[i] = Integer.parseInt(str2[i]);
        }

        for (int i = a.length - 1 ; i >= 0; i--) {
            bufferedWriter.write(a[i] + " ");
        }
        bufferedWriter.flush();
    }
}
