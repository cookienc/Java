package codeup;

import java.util.Scanner;

public class Problem1064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println((a > b) ? ((b > c) ? c : b) : ((a > c) ? c : a));
    }
}
