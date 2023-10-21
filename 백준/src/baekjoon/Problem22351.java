package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem22351 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String s = br.readLine();

        for (int i = 0; i < 3; i++) {
            final Result result = findResult(s, i);
            if (result.isEnd) {
                System.out.println(result.start + " " + result.end);
                return;
            }
        }
    }

    private static Result findResult(final String s, final int index) {
        final int first = Integer.parseInt(s.substring(0, index + 1));
        String tmp = "" + first;
        String start = "" + first;
        String end = "";
        boolean isEnd = false;
        int i = first + 1;
        int count = 0;
        for (count = 0; count < s.length(); count++) {
            if (s.equals(tmp)) {
                isEnd = true;
                break;
            }
            if (s.contains(tmp)) {
                tmp += i;
                end = String.valueOf(i);
                i++;
            }
        }

        if (isEnd && count == 0) {
            return new Result(start, start, isEnd);
        }
        return new Result(start, end, isEnd);
    }
    
    private static class Result {
        String start;
        String end;
        boolean isEnd;

        public Result(final String start, final String end, final boolean isEnd) {
            this.start = start;
            this.end = end;
            this.isEnd = isEnd;
        }
    }

}
