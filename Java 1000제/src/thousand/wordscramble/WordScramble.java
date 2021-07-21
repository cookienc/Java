package thousand.wordscramble;

class WordScramble {
    public static void main(String[] args) {
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"};

        String answer = getAnswer(strArr);
        String question = getScrambledWord(answer);

        System.out.println("Question:"+question);
        System.out.println("Answer:"+answer);
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