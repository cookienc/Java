package codeup;

import java.util.Scanner;

public class Problem1026 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] time = scanner.nextLine().split(":");
        System.out.println(Integer.parseInt(time[1]));
    }
}
