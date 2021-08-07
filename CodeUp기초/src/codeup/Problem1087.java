package codeup;

import java.io.*;

public class Problem1087 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Long num = Long.parseLong(bufferedReader.readLine());
        Long sum = 0L;

        for (int i = 1; num > sum; i++) {
            sum += i;
        }

        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.flush();

    }
}
