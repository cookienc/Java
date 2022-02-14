package baekjoon;

import java.util.Scanner;

public class Problem9498 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int score = sc.nextInt();

			if (score < 60) {
				System.out.println("F");
				return;
			}

			if (score < 70) {
				System.out.println("D");
				return;
			}

			if (score < 80) {
				System.out.println("C");
				return;
			}

			if (score < 90) {
				System.out.println("B");
				return;
			}
			System.out.println("A");
		}
	}
}
