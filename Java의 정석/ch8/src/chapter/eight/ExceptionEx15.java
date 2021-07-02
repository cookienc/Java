package chapter.eight;

import java.io.*;

public class ExceptionEx15 {
    public static void main(String[] args) {
        File f = createFile(args[0]);
        System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
    }

    static File createFile(String fileName) throws Exception {
        try {
            if (fileName == null || fileName.equals(""))
                throw new Exception("파일이름이 유효하지 않습니다.");
        } catch (Exception e) {
            fileName = "제목없음.txt";
        } finally {
            File f = new File(fileName);
            creatNewFile(f);
            return f;
        }
    }

    static void creatNewFile(File f) {
        try{
            f.createNewFile();
        } catch(Exception e) { }
    }
}
