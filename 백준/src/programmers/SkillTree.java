package programmers;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SkillTree {

    static class Solution {
        private static char[] skill;

        public static void main(String[] args) {
            final String skill = "CBD";
            final String[] skill_trees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};
            System.out.println(solution(skill, skill_trees));
        }

        public static int solution(String skill, String[] skill_trees) {
            Solution.skill = skill.toCharArray();

            int answer = 0;
            for(String st : skill_trees) {
                if(isRight(st)) {
                    answer++;
                }
            }

            return answer;
        }

        private static boolean isRight(String learn) {
            final Queue<Character> orders  = new LinkedList<>();
            for (final char s : skill) {
                orders.add(s);
            }

            final Queue<Character> learns = new LinkedList<>();
            for (final char c : learn.toCharArray()) {
                learns.add(c);
            }

            while (!learns.isEmpty()) {
                final Character curLearn = learns.peek();
                final Character curOrder = orders.peek();
                if (Objects.equals(curOrder, curLearn)) {
                    orders.poll();
                    learns.poll();
                    continue;
                }

                if (orders.contains(curLearn)) {
                    return false;
                }

                learns.poll();
            }

            return true;
        }
    }
}
