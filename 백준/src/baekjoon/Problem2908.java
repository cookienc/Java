package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2908
 */
public class Problem2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		String newA = String.valueOf(A.charAt(2)) +
				String.valueOf(A.charAt(1)) +
				String.valueOf(A.charAt(0));

		String newB = String.valueOf(B.charAt(2)) +
				String.valueOf(B.charAt(1)) +
				String.valueOf(B.charAt(0));

		System.out.println(Integer.parseInt(newA) > Integer.parseInt(newB)?
							newA : newB);
	}
}
