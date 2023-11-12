package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalInformationCollectionValidityPeriod {

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            final Map<String, Integer> validates = new HashMap<>();
            for (final String term : terms) {
                final String[] t = term.split(" ");
                final String type = t[0];
                final int valid = Integer.parseInt(t[1]);
                validates.put(type, valid);
            }

            final List<Integer> answers = new ArrayList<>();
            int cnt = 1;
            for (final String privacy : privacies) {
                final String[] information = privacy.split(" ");
                final String[] collectDates = information[0].split("\\.");
                final String term = information[1];

                final Integer m = validates.get(term);
                int year = Integer.parseInt(collectDates[0]);
                int month = Integer.parseInt(collectDates[1]);
                final int day = Integer.parseInt(collectDates[2]);
                if (month + m > 12) {
                    int newMonth = month + m;
                    while (newMonth > 12) {
                        year++;
                        newMonth -= 12;
                    }
                    month = newMonth;
                } else {
                    month += m;
                }

                final String expireDate = String.format("%02d.%02d.%02d", year, month, day);
                if (today.compareTo(expireDate) >= 0) {
                    answers.add(cnt);
                }
                cnt++;
            }
            return answers.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}
