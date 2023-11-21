package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTable {

    public static void main(String[] args) {
//        String[] commands = new String[]{
//                "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
//        };
        String[] commands = new String[]{
                "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"
        };
//        String[] commands = new String[]{
//                "UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 3 3", "UNMERGE 1 1", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"};
        final Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(commands)));
    }

    static class Solution {

        private static final String UPDATE = "UPDATE";
        private static final String MERGE = "MERGE";
        private static final String UNMERGE = "UNMERGE";
        private static final String EMPTY = "EMPTY";
        private static final Table[][] tables = new Table[51][51];

        public String[] solution(String[] commands) {

            for (int r = 0; r < 51; r++) {
                for (int c = 0; c < 51; c++) {
                    tables[r][c] = new Table(r, c, EMPTY);
                }
            }

            final List<String> answers = new ArrayList<>();
            for (final String command : commands) {
                final String[] splits = command.split(" ");
                final String com = splits[0];
                if (com.equals(UPDATE)) {
                    update(splits);
                    continue;
                }
                if (com.equals(MERGE)) {
                    merge(splits);
                    continue;
                }
                if (com.equals(UNMERGE)) {
                    unmerge(splits);
                    continue;
                }

                print(splits, answers);
            }

            return answers.toArray(String[]::new);
        }

        private void update(final String[] commands) {
            if (commands.length == 4) {
                updateBy(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), commands[3]);
                return;
            }
            updateAll(commands[1], commands[2]);
        }

        private void updateBy(final int row, final int col, final String value) {
            /**
             * "UPDATE r c value"
             * (r, c) 위치의 셀을 선택합니다.
             * 선택한 셀의 값을 value로 바꿉니다.
             * 머지가 되어있으면 다 바꿔야 함
             */
            final Table target = tables[row][col];

            for (int r = 1; r < 51; r++) {
                for (int c = 1; c < 51; c++) {
                    final Table cur = tables[r][c];
                    if (cur.r == target.r && cur.c == target.c) {
                        tables[r][c].change(value);
                    }
                }
            }
            target.change(value);
        }

        private void updateAll(final String from, final String to) {
            /**
             * "UPDATE value1 value2"
             * value1을 값으로 가지고 있는 모든 셀을 선택합니다.
             * 선택한 셀의 값을 value2로 바꿉니다.
             */
            for (final Table[] table : tables) {
                for (final Table t : table) {
                    if (t.value.equals(from)) {
                        t.change(to);
                    }
                }
            }
        }

        private void merge(final String[] commands) {
            /**
             * "MERGE r1 c1 r2 c2"
             * (r1, c1) 위치의 셀과 (r2, c2) 위치의 셀을 선택하여 병합합니다.
             * 선택한 두 위치의 셀이 같은 셀일 경우 무시합니다.
             * 선택한 두 셀은 서로 인접하지 않을 수도 있습니다. 이 경우 (r1, c1) 위치의 셀과 (r2, c2) 위치의 셀만 영향을 받으며, 그 사이에 위치한 셀들은 영향을 받지 않습니다.
             * 두 셀 중 한 셀이 값을 가지고 있을 경우 병합된 셀은 그 값을 가지게 됩니다.
             * 두 셀 모두 값을 가지고 있을 경우 병합된 셀은 (r1, c1) 위치의 셀 값을 가지게 됩니다.
             * 이후 (r1, c1) 와 (r2, c2) 중 어느 위치를 선택하여도 병합된 셀로 접근합니다.
             */
            final int fr = Integer.parseInt(commands[1]);
            final int fc = Integer.parseInt(commands[2]);
            final int tr = Integer.parseInt(commands[3]);
            final int tc = Integer.parseInt(commands[4]);

            if (fr == tr && fc == tc) {
                return;
            }

            final Table from = tables[fr][fc];
            final Table to = tables[tr][tc];
            final String targetValue = from.value.equals(EMPTY) ? to.value : from.value;

            for (int r = 1; r < 51; r++) {
                for (int c = 1; c < 51; c++) {
                    final Table cur = tables[r][c];
                    if ((cur.r == from.r && cur.c == from.c) || (cur.r == to.r && cur.c == to.c)) {
                        tables[r][c] = new Table(fr, fc, targetValue);
                    }
                }
            }
        }

        private void unmerge(final String[] commands) {
            /**
             * (r, c) 위치의 셀을 선택하여 해당 셀의 모든 병합을 해제합니다.
             * 선택한 셀이 포함하고 있던 모든 셀은 프로그램 실행 초기의 상태로 돌아갑니다.
             * 병합을 해제하기 전 셀이 값을 가지고 있었을 경우 (r, c) 위치의 셀이 그 값을 가지게 됩니다.
             */
            final int row = Integer.parseInt(commands[1]);
            final int col = Integer.parseInt(commands[2]);
            final Table target = tables[row][col];
            final String value = target.value;

            for (int r = 1; r < 51; r++) {
                for (int c = 1; c < 51; c++) {
                    final Table cur = tables[r][c];
                    if (cur.r == target.r && cur.c == target.c) {
                        tables[r][c] = new Table(r, c, EMPTY);
                    }
                }
            }

            tables[row][col] = new Table(row, col, value);
        }

        private void print(final String[] commands, final List<String> answers) {
            /**
             * (r, c) 위치의 셀을 선택하여 셀의 값을 출력합니다.
             * 선택한 셀이 비어있을 경우 "EMPTY"를 출력합니다.
             */
            answers.add(tables[Integer.parseInt(commands[1])][Integer.parseInt(commands[2])].value);
        }

        private static class Table {
            int r;
            int c;
            String value;

            public Table(final int r, final int c, final String value) {
                this.r = r;
                this.c = c;
                this.value = value;
            }

            public void change(final String value) {
                this.value = value;
            }
        }
    }
}
