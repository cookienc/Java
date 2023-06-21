package programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FeatureDevelopment {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answers = new int[101];

            int time = 0;
            Deque<Integer> deque = new LinkedList<>();

            for (int p : progresses) {
                deque.add(p);
            }

            int index = 0;
            while (!deque.isEmpty()) {
                int progress = deque.removeFirst();

                while (progress + speeds[index] * time < 100) {
                    time++;
                }

                answers[time]++;
                index++;
            }

            return Arrays.stream(answers)
                    .filter(a -> a != 0)
                    .toArray();
        }
    }
}
