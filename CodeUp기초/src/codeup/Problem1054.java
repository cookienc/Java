package codeup;

import java.util.Scanner;

public class Problem1054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println((a == 1 && b == 1)  ? 1 : 0);
    }
}
