package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  출처: https://www.acmicpc.net/problem/1330
 */
public class Problem1330 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			StringTokenizer st = new StringTokenizer(bf.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A > B) {
				bw.write(">");
			}

			if (A < B) {
				bw.write("<");
			}

			if (A == B) {
				bw.write("==");
			}

			bw.flush();
		}
	}
}
