package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2941
 */
public class Problem2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();

		String regex1 = "(dz=)";
		String regex2 = "(c=)|(c\\-)|(d\\-)|(lj)|(nj)|(s=)|(z=)";
		word = word.replaceAll(regex1, "A");
		word = word.replaceAll(regex2, "A");
		int replace = word.length();
		System.out.println(replace);
	}
}
