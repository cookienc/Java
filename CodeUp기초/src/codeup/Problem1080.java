package codeup;

import java.util.Scanner;

public class Problem1080 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int sum = 0;
        int i;

        for (i = 1; i <= num; i++) {

            sum += i;

            if (sum >= num) {
                break;
            }
        }

        System.out.println(i);
    }
}
