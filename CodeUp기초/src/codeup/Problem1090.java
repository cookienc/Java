package codeup;

import java.io.*;

public class Problem1090 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");

        long a = Integer.parseInt(str[0]);
        long r = Integer.parseInt(str[1]);
        long n = Integer.parseInt(str[2]);

        long answer =(long) (a * Math.pow(r, (n - 1)));

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();

    }
}
