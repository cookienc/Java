package thousand.wordscramble;

public class Answer {
    public static String getAnswer(String[] strArr) {
        return strArr[((int) Math.random() * 10) % strArr.length];
    }
}
