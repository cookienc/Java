package codeup;

import java.io.*;

public class Problem1089 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");

        int a = Integer.parseInt(str[0]);
        int d = Integer.parseInt(str[1]);
        int n = Integer.parseInt(str[2]);

        int answer = (n - 1) * d + a;

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();

    }
}
