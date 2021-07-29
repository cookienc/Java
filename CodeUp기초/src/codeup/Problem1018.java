package codeup;

import java.util.Scanner;

public class Problem1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] time = sc.nextLine().split(":");
        String hour = time[0];
        String minute = time[1];

        System.out.println(hour + ":" + minute);
    }
}
