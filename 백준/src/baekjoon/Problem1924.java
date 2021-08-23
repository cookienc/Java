package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1924 {

    private static final String[] month = {
            "", "31", "28", "31", "30", "31"
            , "30", "31", "31", "30", "31"
            , "30", "31"
    };

    private static final String[] day = {
            "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"
    };



    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());

        int monthToDay = 0;

        boolean condition = (((x == 1) || (x == 3) || (x == 5) || (x == 7) || (x == 8) || (x == 10) || (x == 12)) && (y > 31)) ||
                (((x == 4) || (x == 6) || (x == 9) || (x == 11)) && (y > 30)) ||
                ((x == 2) && (y > 28)) ||
                (y < 1);

        if(condition)  {
            throw new Exception("범위가 틀렸습니다.");
        }

        for (int i = 1; i < x; i++) {
            monthToDay += Integer.parseInt(month[i]);
        }

        monthToDay += y;

        System.out.println(day[(monthToDay % 7)]);

    }
}
