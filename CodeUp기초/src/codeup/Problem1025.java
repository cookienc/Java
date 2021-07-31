package codeup;

import java.util.Scanner;

public class Problem1025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        for (int i = 0; i < number.length(); i++) {
            System.out.print("[" + number.charAt(i));
            for (int j = number.length() - 1; j > i; j--)
                System.out.print("0");
            System.out.println("]");
        }
    }
}
