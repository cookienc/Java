package codeup;

import java.util.Scanner;

public class Problem1083 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(16);

        for (int i = 1; i <= a; i++) {
            if (i % 3 == 0) {
                System.out.print("X ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
