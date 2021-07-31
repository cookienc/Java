package codeup;

import java.util.Scanner;

public class Problem1027 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] date = scanner.nextLine().split("\\.");

        String year = String.format("%04d", Integer.parseInt(date[0]));
        String month = String.format("%02d", Integer.parseInt(date[1]));
        String day = String.format("%02d", Integer.parseInt(date[2]));

        System.out.println(day + "-" + month + "-" + year);

        scanner.close();
    }
}
