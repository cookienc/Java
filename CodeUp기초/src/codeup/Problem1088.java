package codeup;

import java.io.*;

public class Problem1088 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= num; i++) {

            if(i % 3 == 0) {
                continue;
            }

            bufferedWriter.write(i + " ");
        }

        bufferedWriter.flush();

    }
}
