package codeup;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Problem1095 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bufferedReader.readLine().split(" ");
        String[] str2 = bufferedReader.readLine().split(" ");

        int num = Integer.parseInt(str[0]);

        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            a.add(Integer.parseInt(str2[i]));
        }

        Collections.sort(a);

        bufferedWriter.write(String.valueOf(a.get(0)));

        bufferedWriter.flush();
    }
}