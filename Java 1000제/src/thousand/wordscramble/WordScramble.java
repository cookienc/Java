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

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if((input.equals("q")) || (input.equals("Q"))) System.exit(0);

            if(input.equals(answer)) break;

            scanner.close();
        } // while

    } // main
}


