package codeup;

import java.util.Scanner;

public class Problem1012 {
    public static void main(String[] args) {
        float f;
        Scanner sc = new Scanner(System.in);
        f = sc.nextFloat();
        String s = String.format("%.6f", f);
        System.out.println(s);
    }
}
