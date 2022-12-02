package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/17478
 */
public class Problem17478 {

    private static final String WHAT_IS_RECURSIVE_FUNCTION = "\"재귀함수가 뭔가요?\"";
    private static final String FIRST = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    private static final String SECOND = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    private static final String THIRD = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    private static final String END = "라고 답변하였지.";
    private static final String RECURSIVE_WORD = "____";
    private static int N;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(0);
        printSentence(1);
        printEndMessage(0);
    }

    public static void printSentence(final int cur) {
        recur(cur);
        if (cur != N) {
            printSentence(cur + 1);
        }

        printEndMessage(cur);
    }

    private static void recur(final int cur) {
        System.out.print(RECURSIVE_WORD.repeat(cur));
        System.out.println(WHAT_IS_RECURSIVE_FUNCTION);

        if (cur == N) {
            System.out.print(RECURSIVE_WORD.repeat(cur));
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            return;
        }

        System.out.print(RECURSIVE_WORD.repeat(cur));
        System.out.println(FIRST);
        System.out.print(RECURSIVE_WORD.repeat(cur));
        System.out.println(SECOND);
        System.out.print(RECURSIVE_WORD.repeat(cur));
        System.out.println(THIRD);
    }

    private static void printEndMessage(final int cur) {
        System.out.print(RECURSIVE_WORD.repeat(cur));
        System.out.println(END);
    }
}
