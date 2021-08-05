package codeup;

import java.util.Scanner;

public class Problem1075 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        while (a >= 1) {
            System.out.println(--a);
        }
    }
}
