package codeup;

import java.io.*;

/**
 * [v] 1. 크기 10x10 미로
 * [v] 2. 개미는 오른쪽으로 이동하다가 벽(1)을 만나면 아래로 움직임
 * [v] 3. 아래쪽으로 움직이다가 오른쪽 벽(1)이 없어지면 다시 오른쪽으로 움직임
 * [v] 4. 개미의 이동경로는 숫자 9로 표현
 * [v] 5. 개미가 먹이(2)를 만나면 그자리에서 멈추고 프린트.
 */

public class Problem1099 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] maze = new String[10][10];

        for (int i = 0; i < 10; i++) {
            maze[i] = bufferedReader.readLine().split(" ");
        }

        int x = 1;
        int y = 1;

        while(true) {
            if(maze[x][y].equals("2")) {
                maze[x][y] = "9";
                break;
            }

            maze[x][y] = "9";

            if(maze[x][y + 1].equals("0") || maze[x][y + 1].equals("2")) {
                y++;
            } else if(maze[x][y + 1].equals("1")) {
                if(maze[x + 1][y].equals("0") || maze[x+1][y].equals("2")) {
                    x++;
                } else if(maze[x + 1][y].equals("1")){
                    break;
                }
            }
        }

        for (String[] b : maze) {
            for (String a : b) {
                bufferedWriter.write(a + " ");
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
    }
}