package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem14646 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        Set<Integer> stickers = new HashSet<>();
        while (st.hasMoreTokens()) {
            final int menu = Integer.parseInt(st.nextToken());

            if (stickers.contains(menu)) {
                stickers.remove(menu);
                continue;
            }

            stickers.add(menu);
            max = Math.max(max, stickers.size());
        }

        System.out.println(max);
    }
}
