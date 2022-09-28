package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1713
 */
public class Problem1713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());


		StringTokenizer st = new StringTokenizer(br.readLine());
		Student[] students = new Student[N];
		Arrays.fill(students, new Student(-1, -1, -1));

		for (int i = 0; i < M; i++) {
			int name = Integer.parseInt(st.nextToken());
			boolean recommend = false;
			int recommendIdx = 0;

			Arrays.sort(students);

			for (int j = 0; j < N; j++) {
				if (students[j].name == name) {
					recommendIdx = j;
					recommend = true;
					break;
				}
			}

			if (recommend) {
				students[recommendIdx].cnt++;
				continue;
			}

			students[0] = new Student(name, 1, i);
		}

		Arrays.sort(students, Comparator.comparingInt(s -> s.name));
		for (int i = 0; i < N; i++) {
			if (students[i].name == -1) {
				continue;
			}
			System.out.print(students[i].name + " ");
		}
	}

	private static class Student implements Comparable<Student> {
		int name;
		int cnt;
		int time;

		public Student(int name, int cnt, int time) {
			this.name = name;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Student o) {
			if (this.cnt == o.cnt) {
				return time - o.time;
			}

			return this.cnt - o.cnt;
		}
	}
}
