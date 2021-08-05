package codeup;

import java.util.Scanner;

public class Problem1079 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            char a = scanner.next().charAt(0);

            if(a=='q') {
                System.out.println(a);
                break;
            }

            System.out.println(a);
        }

    }
}

