package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/19583
 */
public class Problem19583 {

	private static String start;
	private static String end;
	private static String streamEnd;
	private static Map<String, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		start = st.nextToken();
		end = st.nextToken();
		streamEnd = st.nextToken();

		map = new HashMap<>();

		while (true) {
			String s = br.readLine();
			if (s == null || s.equals("")) {
				break;
			}

			String[] str = s.split(" ");
			String time = str[0];
			String name = str[1];

			compareTime(time, name);
		}

		int count = (int) map.entrySet().stream()
				.filter(it -> it.getValue() >= 2)
				.count();

		System.out.println(count);
	}

	private static void compareTime(String time, String name) {
		int hour = getHour(time);
		int minute = getMinute(time);

		int startHour = getHour(start);
		int startMinute = getMinute(start);

		if ((startHour > hour || (startHour == hour && startMinute >= minute))) {
			map.put(name, 1);
		}

		int endHour = getHour(end);
		int endMinute = getMinute(end);

		int streamEndHour = getHour(streamEnd);
		int streamEndMinute = getMinute(streamEnd);

		if ((endHour < hour || (endHour == hour && endMinute <= minute)) &&
				(streamEndHour > hour || (streamEndHour == hour && streamEndMinute >= minute))) {
			if (map.containsKey(name)) {
				map.merge(name, 1, Integer::sum);
			}
		}
	}

	private static int getHour(String start) {
		String[] time = start.split(":");
		return Integer.parseInt(time[0]);
	}

	private static int getMinute(String start) {
		String[] time = start.split(":");
		return Integer.parseInt(time[1]);
	}
}