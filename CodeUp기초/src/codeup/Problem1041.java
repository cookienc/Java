package codeup;

import java.util.Scanner;

public class Problem1041 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char word = scanner.nextLine().charAt(0);

        System.out.println((char)(word + 1));

        scanner.close();
    }
}
