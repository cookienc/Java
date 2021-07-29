package codeup;

import java.util.Scanner;

public class Problem1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] date = sc.nextLine().split("\\.");

        String year = String.format("%04d", Integer.parseInt(date[0]));
        String month = String.format("%02d", Integer.parseInt(date[1]));
        String day = String.format("%02d", Integer.parseInt(date[2]));

        System.out.println(year + "." + month + "." + day);
    }
}
