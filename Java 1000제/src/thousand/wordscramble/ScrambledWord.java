package thousand.wordscramble;

public class ScrambledWord {

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

