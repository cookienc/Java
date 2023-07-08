package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/17478
 */
public class Problem17478 {

    private static final String HEADER = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    private static final String CONTENTS_FIRST = "\"재귀함수가 뭔가요?\"\n";
    private static final String CONTENTS_SECOND = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    private static final String CONTENTS_THIRD = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    private static final String CONTENTS_FOURTH = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    private static final String ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    private static final String FOOTER = "라고 답변하였지.\n";
    private static final String PREFIX = "____";
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb.append(HEADER);
        recursion(0);
        System.out.println(sb);
    }

    private static void recursion(final int depth) {
        if (depth > N) {
            return;
        }

        final String prefix = PREFIX.repeat(depth);
        sb.append(prefix).append(CONTENTS_FIRST);
        if (depth != N) {
            sb.append(prefix).append(CONTENTS_SECOND);
            sb.append(prefix).append(CONTENTS_THIRD);
            sb.append(prefix).append(CONTENTS_FOURTH);
        } else {
            sb.append(prefix).append(ANSWER);
        }
        recursion(depth + 1);
        sb.append(prefix).append(FOOTER);
    }
}
