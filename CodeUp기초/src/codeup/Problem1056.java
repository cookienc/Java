package codeup;

import java.util.Scanner;

public class Problem1056 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println((a != b) ? 1 : 0);
    }
}
