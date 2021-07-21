package thousand.wordscramble;
import java.util.*;

class WordScramble {
    public static void main(String[] args) {
        String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};

        String answer = Answer.getAnswer(strArr);
        String question = ScrambledWord.getScrambledWord(answer);

        while (true) {
            System.out.println("Question :" + question);
            System.out.print("Your answer is :");


            // 1. 화면을 통해 사용자의 입력을 받는다.(Scanner클래스 사용)

            // 2. 사용자가 q 또는 Q를 입력하면 프로그램을 종료한다.

            // 3. 사용자가 정답을 맞출때까지 반복하다가

            //     사용자가 정답을 맞추면, while문을 빠져나간다.

        } // while

    } // main
}


