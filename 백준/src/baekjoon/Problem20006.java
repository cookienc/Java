package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparing;

public class Problem20006 {
    /**
     * 처음 입장한 플레이어 레벨 기준 -10 ~ +10만 입장가능
     * 입장 가능하면 입장, 정원이 찰 때까지 기다림
     * 여러개 입장 가능하면 가장 먼저 생긴 순
     * 모두 차면 게임 시작
     */

    private static int m;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        final List<Room> rooms = new ArrayList<>();
        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int level = Integer.parseInt(st.nextToken());
            final String name = st.nextToken();
            final Player player = new Player(level, name);

            if (rooms.isEmpty()) {
                final Room room = new Room();
                room.add(player);
                rooms.add(room);
                continue;
            }

            boolean isEnter = false;
            for (Room room : rooms) {
                if (room.isRightPlayer(player) && !room.isStart()) {
                    room.add(player);
                    isEnter = true;
                    break;
                }
            }

            if (!isEnter) {
                final Room room = new Room();
                room.add(player);
                rooms.add(room);
            }
        }

        for (final Room room : rooms) {
            String status = "";
            if (room.isStart()) {
                status = "Started!";
            } else {
                status = "Waiting!";
            }

            System.out.println(status);
            room.players.stream()
                    .sorted(comparing(player -> player.name))
                    .forEach(player -> System.out.println(player.level + " " + player.name));
        }
    }

    private static class Room {
        final List<Player> players = new ArrayList<>();

        public void add(final Player player) {
            players.add(player);
        }

        public boolean isRightPlayer(final Player enterPlayer) {
            final int firstPlayerLevel = players.get(0).level;
            return Math.abs(enterPlayer.level - firstPlayerLevel) <= 10;
        }

        public boolean isStart() {
            return players.size() == m;
        }

    }

    private static class Player {
        int level;
        String name;

        public Player(final int level, final String name) {
            this.level = level;
            this.name = name;
        }
    }
}
