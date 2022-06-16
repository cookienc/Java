package baekjoon;

import java.io.*;

/**
 * 출처: https://www.acmicpc.net/problem/10798
 */
public class Problem10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Character[][] word = new Character[5][15];

		for (int r = 0; r < 5; r++) {
			char[] ch = br.readLine().toCharArray();
			for (int c = 0; c < 15; c++) {
				if (c >= ch.length) {
					break;
				}
				word[r][c] = ch[c];
			}
		}

		for (int c = 0; c < 15; c++) {
			for (int r = 0; r < 5; r++) {
				if (word[r][c] == null) {
					continue;
				}
				bw.write(word[r][c]);
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
