package codeup;

import java.util.Scanner;

public class Problem1076 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char ch = scanner.nextLine().charAt(0);

        for (int i = 97; i <= (int)ch; i++) {
            System.out.println((char)i);
        }
    }
}
