package codeup;

import java.util.Scanner;

public class Problem1078 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            if(i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
