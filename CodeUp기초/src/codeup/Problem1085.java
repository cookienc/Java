package codeup;

import java.io.*;

public class Problem1085 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");

        double h = Double.parseDouble(str[0]);
        double b = Double.parseDouble(str[1]);
        double c = Double.parseDouble(str[2]);
        double s = Double.parseDouble(str[3]);

        String storage = String.valueOf(Math.round((h * b * c * s) / 8 / 1024 / 1024 * 10) / 10.0);
        bufferedWriter.write(storage + " MB");
        bufferedWriter.flush();
    }
}
