package baekjoon;

import java.io.*;

/**
 * 출처: https://www.acmicpc.net/problem/2902
 */
public class Problem2902 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] word = br.readLine().toCharArray();

		for (char c : word) {
			if ('A' <= c && c <= 'Z') {
				bw.write(c);
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
