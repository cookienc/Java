package thousand.wordscramble;
import java.util.*;

class WordScramble {
    public static void main(String[] args) {
        String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};
        Scanner scanner = new Scanner(System.in);

        while(true) {

            String answer = Answer.getAnswer(strArr);
            String question = ScrambledWord.getScrambledWord(answer);

            while (true) {
                System.out.println("Question :" + question);
                System.out.print("Your answer is :");
                String input = scanner.nextLine();

                if ((input.equals("q")) || (input.equals("Q"))) System.exit(0);

                if (input.equals(answer)) {
                    System.out.println("정답입니다!!");
                    break;
                }
            } // while
        }
    } // main
}


