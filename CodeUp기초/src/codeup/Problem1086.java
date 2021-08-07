package codeup;

import java.io.*;

public class Problem1086 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");

        double w = Long.parseLong(str[0]);
        double h = Long.parseLong(str[1]);
        double b = Long.parseLong(str[2]);

        String storage = String.format("%.2f", w * h * b * 1 / 8.0 / 1024 / 1024);

        bufferedWriter.write(storage + " MB");
        bufferedWriter.flush();
    }
}
