package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11655  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        char sentence[] = bufferedReader.readLine().toCharArray();

        for (char word : sentence) {
            if ('a' <= word && word <= 'z' - 13)
                stringBuilder.append((char)(word + 13));
            else if ('z' - 13 < word && word <= 'z')
                stringBuilder.append((char)(word - 13));
            else if ('A' <= word && word <= 'Z' - 13)
                stringBuilder.append((char)(word + 13));
            else if ('Z' - 13 < word && word <= 'Z')
                stringBuilder.append((char)(word - 13));
            else
                stringBuilder.append(word);
        }

        System.out.println(stringBuilder);
    }
}
