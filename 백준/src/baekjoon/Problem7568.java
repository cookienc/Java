package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/7568
 */
public class Problem7568 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int w = Integer.parseInt(st.nextToken());
            final int h = Integer.parseInt(st.nextToken());

            people[i] = new Person(1, w, h);
        }

        for (int i = 0; i < N; i++) {
            final Person target = people[i];
            int grade = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                final Person source = people[j];
                if (target.height < source.height && target.weight < source.weight) {
                    grade++;
                }
            }
            target.grade = grade;
        }

        final StringBuilder sb = new StringBuilder();
        for (final Person person : people) {
            sb.append(person.grade).append(" ");
        }
        System.out.println(sb);
    }

    private static class Person {

        int grade;
        int weight;
        int height;

        public Person(final int grade, final int weight, final int height) {
            this.grade = grade;
            this.weight = weight;
            this.height = height;
        }
    }
}
