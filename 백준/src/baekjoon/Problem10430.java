package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10430  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        StringBuilder stringBuilder = new StringBuilder();

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        stringBuilder.append((a + b) % c)
                .append("\n");
        stringBuilder.append(((a % c) + (b % c)) % c)
                .append("\n");
        stringBuilder.append((a * b) % c)
                .append("\n");
        stringBuilder.append(((a % c) * (b % c)) % c)
                .append("\n");

        System.out.println(stringBuilder);


    }
}
