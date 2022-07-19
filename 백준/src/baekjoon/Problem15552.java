package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15552 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
