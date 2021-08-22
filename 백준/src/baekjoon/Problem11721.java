package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem11721 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        List<String> list = new ArrayList<>();

        try {

            String str = bufferedReader.readLine();
            for (int i = 0; i < str.length(); i++) {
                list.add("" + str.charAt(i));
            }

            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));

                if((i % 10) == 9 && i != 0) {
                    stringBuilder.append(NEW_LINE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder);

    }
}
