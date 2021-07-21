package thousand.wordscramble;
import java.util.*;

class WordScrambleEx2 {
    public static void main(String[] args) {
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"};

        String answer = getAnswer(strArr);
        String question = getScrambledWord(answer);

        while(true) {
            System.out.println("Question :" + question);
            System.out.print("Your answer is :");


            // 1. 화면을 통해 사용자의 입력을 받는다.(Scanner클래스 사용)

            // 2. 사용자가 q 또는 Q를 입력하면 프로그램을 종료한다.

            // 3. 사용자가 정답을 맞출때까지 반복하다가

            //     사용자가 정답을 맞추면, while문을 빠져나간다.

        } // while

    } // main

    public static String getAnswer(String[] strArr) {
        return strArr[((int) Math.random() * 10) % strArr.length];
    }

    public static String getScrambledWord(String str) {
        char[] word = str.toCharArray();

        for(int i = 0; i < word.length; i++) {
            int index = (int) (Math.random() * str.length());

            char tmp = word[i];

            word[i] = word[index];
            word[index] = tmp;
        }
        return new String(word);
    } // scramble(String str)
}