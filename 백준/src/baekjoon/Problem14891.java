package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14891
 */
public class Problem14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Gear[] gears = new Gear[4];
		for (int i = 0; i < 4; i++) {
			char[] arr = br.readLine().toCharArray();
			int n = arr[0] - '0';
			int ne = arr[1] - '0';
			int e = arr[2] - '0';
			int se = arr[3] - '0';
			int s = arr[4] - '0';
			int sw = arr[5] - '0';
			int w = arr[6] - '0';
			int nw = arr[7] - '0';
			gears[i] = new Gear(n, ne, e, se, s, sw, w, nw);
		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int which = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());

			if (direction == 1) {
				moveClockwise(gears, which);
			} else {
				moveCounterClockwise(gears, which);
			}
		}

		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += gears[i].n * (int) Math.pow(2, i);
		}

		System.out.println(sum);
	}

	private static void moveCounterClockwise(Gear[] gears, int which) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{which, -1});

		if (which == 0) {
			if (gears[0].e != gears[1].w) {
				queue.add(new int[]{1, 1});
				if (gears[1].e != gears[2].w) {
					queue.add(new int[]{2, -1});
					if (gears[2].e != gears[3].w) {
						queue.add(new int[]{3, 1});
					}
				}
			}
		}

		if (which == 1) {
			if (gears[1].w != gears[0].e) {
				queue.add(new int[]{0, 1});
			}

			if (gears[1].e != gears[2].w) {
				queue.add(new int[]{2, 1});
				if (gears[2].e != gears[3].w) {
					queue.add(new int[]{3, -1});
				}
			}
		}

		if (which == 2) {
			if (gears[2].e != gears[3].w) {
				queue.add(new int[]{3, 1});
			}

			if (gears[2].w != gears[1].e) {
				queue.add(new int[]{1, 1});
				if (gears[1].w != gears[0].e) {
					queue.add(new int[]{0, -1});
				}
			}
		}

		if (which == 3) {
			if (gears[3].w != gears[2].e) {
				queue.add(new int[]{2, 1});
				if (gears[2].w != gears[1].e) {
					queue.add(new int[]{1, -1});
					if (gears[1].w != gears[0].e) {
						queue.add(new int[]{0, 1});
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] command = queue.poll();
			if (command[1] == 1) {
				gears[command[0]].clockwise();
			} else {
				gears[command[0]].counterClockwise();
			}
		}
	}

	private static void moveClockwise(Gear[] gears, int which) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{which, 1});

		if (which == 0) {
			if (gears[0].e != gears[1].w) {
				queue.add(new int[]{1, -1});
				if (gears[1].e != gears[2].w) {
					queue.add(new int[]{2, 1});
					if (gears[2].e != gears[3].w) {
						queue.add(new int[]{3, -1});
					}
				}
			}
		}

		if (which == 1) {
			if (gears[1].w != gears[0].e) {
				queue.add(new int[]{0, -1});
			}

			if (gears[1].e != gears[2].w) {
				queue.add(new int[]{2, -1});
				if (gears[2].e != gears[3].w) {
					queue.add(new int[]{3, 1});
				}
			}
		}

		if (which == 2) {
			if (gears[2].e != gears[3].w) {
				queue.add(new int[]{3, -1});
			}

			if (gears[2].w != gears[1].e) {
				queue.add(new int[]{1, -1});
				if (gears[1].w != gears[0].e) {
					queue.add(new int[]{0, 1});
				}
			}
		}

		if (which == 3) {
			if (gears[3].w != gears[2].e) {
				queue.add(new int[]{2, -1});
				if (gears[2].w != gears[1].e) {
					queue.add(new int[]{1, 1});
					if (gears[1].w != gears[0].e) {
						queue.add(new int[]{0, -1});
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] command = queue.poll();
			if (command[1] == 1) {
				gears[command[0]].clockwise();
			} else {
				gears[command[0]].counterClockwise();
			}
		}
	}

	private static class Gear {
		int n;
		int ne;
		int e;
		int se;
		int s;
		int sw;
		int w;
		int nw;

		public Gear(int n, int ne, int e, int se, int s, int sw, int w, int nw) {
			this.n = n;
			this.ne = ne;
			this.e = e;
			this.se = se;
			this.s = s;
			this.sw = sw;
			this.w = w;
			this.nw = nw;
		}

		public void clockwise() {
			int tmp = n;
			this.n = nw;
			this.nw = w;
			this.w = sw;
			this.sw = s;
			this.s = se;
			this.se = e;
			this.e = ne;
			this.ne = tmp;
		}

		public void counterClockwise() {
			int tmp = n;
			this.n = ne;
			this.ne = e;
			this.e = se;
			this.se = s;
			this.s = sw;
			this.sw = w;
			this.w = nw;
			this.nw = tmp;
		}
	}
}
