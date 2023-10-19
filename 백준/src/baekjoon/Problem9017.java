package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.util.stream.Collectors.toList;

public class Problem9017 {
    /**
     * 한 팀 여섯명
     * 팀 점수 상위 네명의 점수 합
     * 결승점 통과 순으로 점수를 매김
     * 점수가 낮을 수록 좋은 것
     * 6명이 참가 못하면 실격
     * 동점의 경우 5번째 주자가 빨리 들어오면 합
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());

            int[] members = new int[N];
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final Map<Integer, Integer> teams = new HashMap<>();

            for (int i = 0; i < N; i++) {
                final int team = Integer.parseInt(st.nextToken());
                members[i] = team;
                teams.merge(team, 1, Integer::sum);
            }

            int score = 1;
            final Map<Integer, TeamScore> teamScores = new HashMap<>();
            for (final Integer teamName : teams.keySet()) {
                teamScores.put(teamName, new TeamScore(teamName, 0, 0, 0));
            }

            for (int i = 0; i < N; i++) {
                final int team = members[i];

                if (teams.get(team) < 6) {
                    continue;
                }

                final TeamScore teamScore = teamScores.get(team);
                if (teamScore.cnt < 4) {
                    teamScore.score += score;
                }
                teamScore.cnt++;
                if (teamScore.cnt == 5) {
                    teamScore.fifthScore = score;
                }
                score++;
            }

            int min = Integer.MAX_VALUE;
            final List<TeamScore> haveTeamScores = teamScores.values().stream()
                    .filter(teamScore -> teamScore.score != 0)
                    .collect(toList());
            for (final TeamScore teamScore : haveTeamScores) {
                min = Math.min(min, teamScore.score);
            }

            final int realMin = min;
            final List<TeamScore> minTeams = haveTeamScores.stream()
                    .filter(teamScore -> teamScore.score == realMin)
                    .collect(toList());

            if (minTeams.size() == 1) {
                System.out.println(minTeams.get(0).name);
            } else {
                final List<TeamScore> sortedTeamScore = minTeams.stream()
                        .sorted(Comparator.comparingInt(teamScore -> teamScore.fifthScore))
                        .collect(toList());
                System.out.println(sortedTeamScore.get(0).name);
            }
        }

    }

    private static class TeamScore {
        int name;
        int score;
        int cnt;
        int fifthScore;

        public TeamScore(final int name, final int score, final int cnt, final int fifthScore) {
            this.name = name;
            this.score = score;
            this.cnt = cnt;
            this.fifthScore = fifthScore;
        }
    }
}
