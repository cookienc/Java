package programmers;

public class RepresentableBinaryTree {

    static class Solution {

        public static void main(String[] args) {
            long[] numbers = new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512, 2147516555L};
//[1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1]
//            long[] numbers = new long[]{3};
            final int[] solution = new Solution().solution(numbers);
            for (int i : solution) {
                System.out.print(i + " ");
            }
        }

        public int[] solution(long[] numbers) {
            int[] answer = new int[numbers.length];
            int cnt = -1;
            for (long number : numbers) {
                cnt++;
                final String builder = getBinary(number);
                boolean canMake = judge(builder);
                if (canMake) {
                    answer[cnt] = 1;
                } else {
                    answer[cnt] = 0;
                }
            }

            return answer;
        }

        private boolean judge(final String binary) {
            final int length = binary.length();
            if (length == 1) {
                return true;
            }

            final int middle = length / 2;
            if (binary.charAt(middle) == '0') {
                return judgeZero(binary);
            }

            final int flag = ((length - 1) / 2) % 2;
            if (flag % 2 == 0) {
                return judge(binary.substring(0, middle + 1)) && judge(binary.substring(middle));
            }
            return judge(binary.substring(0, middle)) && judge(binary.substring(middle + 1));
        }

        private boolean judgeZero(final String binary) {
            final int length = binary.length();
            for (int i = 0; i < length; i++) {
                if (binary.charAt(i) != '0') {
                    return false;
                }
            }
            return true;
        }

        private static String getBinary(long number) {
            final StringBuilder sb = new StringBuilder();
            while (!(number == 0 || number == 1)) {
                final long mod = number % 2;
                sb.append(mod);
                number -= mod;
                number /= 2;
            }
            sb.append(number);

            for (int i = 1; i <= 50; i++) {
                final long treeSize = (long) Math.pow(2, i) - 1;
                if (treeSize == sb.length()) {
                    break;
                }

                if (treeSize < sb.length()) {
                    continue;
                }

                int diff = (int) (treeSize - sb.length());
                while (diff-- > 0) {
                    sb.append("0");
                }
                break;
            }
            return sb.reverse().toString();
        }
    }
}
