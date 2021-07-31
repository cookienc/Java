package codeup;

import java.util.Scanner;

public class Problem1023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();

        String[] number = num.split("\\.");

        System.out.println(number[0]);
        System.out.println(number[1]);
    }
}
