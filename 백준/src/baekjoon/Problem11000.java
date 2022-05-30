package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11000
 */
public class Problem11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Room> pq = new PriorityQueue<Room>((r1, r2) -> {
			if (r1.start == r2.start) {
				return r1.end - r2.end;
			}
			return r1.start - r2.start;
		});

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			pq.offer(new Room(startTime, endTime));
		}

		PriorityQueue<Room> rooms = new PriorityQueue<>((r1, r2) -> {
			if (r1.end == r2.end) {
				return r1.start - r2.start;
			}
			return r1.end - r2.end;
		});

		int count = 0;

		while (!pq.isEmpty()) {
			Room nextRoom = pq.poll();

			if (!rooms.isEmpty()) {
				Room curRoom = rooms.peek();

				if (curRoom.canUse(nextRoom)) {
					curRoom.next(nextRoom);
					rooms.poll();
					rooms.offer(nextRoom);
				} else {
					rooms.offer(nextRoom);
					count++;
				}
			} else {
				rooms.offer(nextRoom);
				count++;
			}

		}

		System.out.println(count);
	}

	private static class Room {
		int start;
		int end;

		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public boolean canUse(Room next) {
			if (this.end <= next.start) {
				return true;
			}
			return false;
		}

		public void next(Room nextRoom) {
			this.start = nextRoom.start;
			this.end = nextRoom.end;
		}
	}
}
