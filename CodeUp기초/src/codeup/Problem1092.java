package codeup;

import java.io.*;

public class Problem1092 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");

        long a = Integer.parseInt(str[0]);
        long b = Integer.parseInt(str[1]);
        long c = Integer.parseInt(str[2]);

        long day = 1;

        while (day % a != 0 || day % b != 0 || day % c != 0) {
            day++;
        }

        bufferedWriter.write(String.valueOf(day));
        bufferedWriter.flush();

    }
}
