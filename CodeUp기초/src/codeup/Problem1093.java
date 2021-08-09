package codeup;

import java.io.*;

public class Problem1093 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");
        String[] str2 = bufferedReader.readLine().split(" ");

        int num = Integer.parseInt(str[0]);

        int[] a = new int[23];

        for (int i = 0; i < num; i++) {
            a[Integer.parseInt(str2[i]) - 1]++;
        }

        for (int i = 0; i < a.length; i++) {
            bufferedWriter.write(a[i] + " ");
        }
        bufferedWriter.flush();
    }
}
