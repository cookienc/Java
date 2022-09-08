package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 출처: https://www.acmicpc.net/problem/21942
 */
public class Problem21942 {

	private static int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static String[] L;
	private static long F;
	private static TreeMap<String, Long> fare;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		L = st.nextToken().split("[/:]");
		F = Long.parseLong(st.nextToken());

		fare = new TreeMap<>();
		Map<String, Map<String, Info>> map = new HashMap<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String date = st.nextToken();
			String time = st.nextToken();
			String itemName = st.nextToken();
			String name = st.nextToken();

			if (map.containsKey(itemName)) { //빌려간 아이템 존재
				Map<String, Info> borrower = map.get(itemName);

				if (borrower.containsKey(name)) { //이미 같은 사람이 빌려감 -> 반납
					returnTo(borrower.get(name), name, date, time);
					borrower.remove(name);
				} else { //빌려간 사람이 없으면 -> 빌림
					borrower.put(name, new Info(date, time));
				}

			} else { // 빌려간 아이템이 없으면
				Map<String, Info> tmp = new HashMap<>();
				tmp.put(name, new Info(date, time));
				map.put(itemName, tmp);
			}
		}
		if (fare.isEmpty()) {
			System.out.println(-1);
		} else {
			for (Map.Entry<String, Long> entry : fare.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}

	private static void returnTo(Info info, String name, String date, String time) {
		String[] returnDate = date.split("-");
		String[] borrowDate = info.date.split("-");
		int returnMonth = Integer.parseInt(returnDate[1]);
		int returnDay = Integer.parseInt(returnDate[2]);
		int borrowMonth = Integer.parseInt(borrowDate[1]);
		int borrowDay = Integer.parseInt(borrowDate[2]);

		int sum = returnDay - borrowDay;

		for (int i = borrowMonth; i < returnMonth; i++) {
			sum += day[i];
		}

		if (sum < Integer.parseInt(L[0])) {
			return;
		}

		String[] returnTime = time.split(":");
		String[] borrowTime = info.time.split(":");

		long total = sum * 24 * 60 +
				Integer.parseInt(returnTime[0]) * 60 - Integer.parseInt(borrowTime[0]) * 60 +
				Integer.parseInt(returnTime[1]) - Integer.parseInt(borrowTime[1]);

		long flag = Integer.parseInt(L[0]) * 24 * 60 + Integer.parseInt(L[1]) * 60 + Integer.parseInt(L[2]);

		if (total > flag) {
			long f = (total - flag) * F;
			fare.merge(name, f, Long::sum);
		}
	}

	private static class Info {
		String date;
		String time;

		public Info(String date, String time) {
			this.date = date;
			this.time = time;
		}
	}
}
