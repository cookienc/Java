package codeup;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class problem1002 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("Hello World");
        bw.flush();
        bw.close();
    }
}
