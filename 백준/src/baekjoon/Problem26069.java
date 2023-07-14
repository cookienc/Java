package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem26069 {

    private static final String CHONG = "ChongChong";

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        Set<String> people = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final String name1 = st.nextToken();
            final String name2 = st.nextToken();

            if (name1.equals(CHONG)
                    || name2.equals(CHONG)
                    || people.contains(name1)
                    || people.contains(name2)) {
                people.add(name1);
                people.add(name2);
            }
        }

        System.out.println(people.size());
    }
}
