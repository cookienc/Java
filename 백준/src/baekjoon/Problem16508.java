package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16508
 */
public class Problem16508 {
	private static int min = Integer.MAX_VALUE;
	private static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] make = br.readLine().toCharArray();
		answer = new int[26];

		for (char c : make) {
			answer[c - 'A']++;
		}

		int n = Integer.parseInt(br.readLine());

		Book[] books = new Book[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			books[i] = new Book(name, price);
		}

		for (int i = 0; i < 1 << n; i++) {
			int price = 0;
			int[] check = new int[26];

			for (int j = 0; j < books.length; j++) {
				if ((i & 1 << j) == 0) {
					continue;
				}

				price += books[j].price;

				if (price >= min) {
					break;
				}

				char[] words = books[j].name.toCharArray();
				for (int k = 0; k < words.length; k++) {
					for (int l = 0; l < make.length; l++) {
						if (words[k] == make[l]) {
							check[words[k] - 'A']++;
							break;
						}
					}
				}
			}

			boolean end = false;

			for (int j = 0; j < 26; j++) {
				if (answer[j] > check[j]) {
					end = true;
					break;
				}
			}

			if (end) {
				continue;
			}

			min = Math.min(price, min);
		}

		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}

	private static class Book {
		String name;
		int price;

		public Book(String name, int price) {
			this.name = name;
			this.price = price;
		}
	}
}
