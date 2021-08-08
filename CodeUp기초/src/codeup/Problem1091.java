package codeup;

import java.io.*;

public class Problem1091 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");

        long a = Integer.parseInt(str[0]);
        long m = Integer.parseInt(str[1]);
        long d = Integer.parseInt(str[2]);
        long n = Integer.parseInt(str[3]);

        for (int i = 1; i < n; i++) {
            a = a * m + d;
        }

        bufferedWriter.write(String.valueOf(a));
        bufferedWriter.flush();

    }
}
