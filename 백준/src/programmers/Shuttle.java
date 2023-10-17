package programmers;

import java.util.PriorityQueue;

public class Shuttle {

    public static void main(String[] args) {
        System.out.println("answer1 = " + solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println("answer2 = " + solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println("answer3 = " + solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println("answer4 = " + solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println("answer5 = " + solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println("answer6 = " + solution(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (final String time : timetable) {
            final String[] tt = time.split(":");
            pq.add(Integer.parseInt(tt[0]) * 60 + Integer.parseInt(tt[1]));
        }

        int arrivalTime = 540 - t;
        int lastPersonTime = 0;
        int busSize = 0;
        for (int count = 0; count < n; count++) {
            busSize = 0;
            arrivalTime += t;

            while (!pq.isEmpty() && pq.peek() <= arrivalTime) {
                if (busSize >= m) {
                    break;
                }

                busSize++;
                final Integer crew = pq.poll();
                lastPersonTime = crew;
            }
        }

        String answer = "";
        if (busSize < m) {
            answer = toBusTime(arrivalTime);
        } else {
            answer = toBusTime(lastPersonTime - 1);
        }

        return answer;
    }

    private static String toBusTime(final int arrivalTime) {
        final int hour = arrivalTime / 60;
        final int minute = arrivalTime - hour * 60;
        return String.format("%02d:%02d", hour, minute);
    }
}
