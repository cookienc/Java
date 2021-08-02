package codeup;

import java.util.Scanner;

public class Problem1046 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        System.out.println(a + b + c);
        System.out.printf("%.1f", (a + b + c) / 3f);

    }
}
