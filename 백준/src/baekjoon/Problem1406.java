package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        String word = bufferedReader.readLine();

        List words = new ArrayList<>();

        initialize(word, words);

        int index = words.size();

        int num = Integer.parseInt(bufferedReader.readLine());

        while (num-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String command = stringTokenizer.nextToken();

            switch (command) {

                case "L":
                    if (index != 0) {
                        index--;
                    }
                    break;

                case "D":
                    if (index != words.size()) {
                        index++;
                    }
                    break;

                case "B":
                    if (index != 0) {
                        words.remove(index - 1);
                        index--;
                    }
                    break;

                case "P":
                    words.add(index, stringTokenizer.nextToken());
                    index++;
                    break;
            }
        }
        for (Object o : words) {
            stringBuilder.append(o);
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    private static void initialize(String word, List words) {
        for (int i = 0; i < word.length(); i++) {
            words.add(word.charAt(i));
        }
    }
}
