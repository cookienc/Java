package thousand.wordscramble;
import java.util.*;

class WordScramble {
    public static void main(String[] args) {
        String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};
        Scanner scanner = new Scanner(System.in);

        while(true) {

            String answer = Answer.getAnswer(strArr);
            String question = ScrambledWord.getScrambledWord(answer);
            char[] hint = new char[answer.length()];

            for(int i = 0; i < hint.length; i++) {
                hint[i] = '_';
            }

            while (true) {
                System.out.println("Question :" + question);
                System.out.print("Your answer is :");
                String input = scanner.nextLine();

                if ((input.equals("q")) || (input.equals("Q"))) System.exit(0);

                if (input.equals(answer)) {
                    System.out.println("정답입니다!!");
                    System.out.println();
                    break;
                } else {
                    System.out.println(input + "은 답이 아닙니다.");
                    System.out.println("Hint:"+ Hint.getHint(answer,hint));
                }
            } // while
        }
    } // main
}


