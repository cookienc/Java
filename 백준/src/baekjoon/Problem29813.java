package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem29813 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final Queue<Student> students = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final String name = st.nextToken();
            final int order = Integer.parseInt(st.nextToken());
            students.add(new Student(name, order));
        }

        while (students.size() != 1) {
            final Student first = students.remove();
            int order = first.order;
            while (order-- > 1) {
                students.add(students.remove());
            }

            students.remove();
        }

        System.out.println(students.poll().name);
    }

    private static class Student {

        String name;
        int order;

        public Student(final String name, final int order) {
            this.name = name;
            this.order = order;
        }
    }
}
