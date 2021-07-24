package thousand.wordscramble;

public class Hint {
    public static String getHint(String answer, char[] hint) {
        int count = 0;

        for (char ch : hint) {
            if( ch == '_') {
                count++;
            }
        }

        if(count > 2) {
            while(true) {
                int i = (int)(Math.random() * hint.length);
                if (hint[i] == '_') {
                    hint[i] = answer.charAt(i);
                    break;
                }
            }
        }

        return new String(hint);

    }
}
