import java.io.*;
import java.util.*;

class Main {
	static class Mountain implements Comparable<Mountain> {
		int minX, maxX;

		public Mountain(int minX, int maxX) {
			super();
			this.minX = minX;
			this.maxX = maxX;
		}

		@Override
		public int compareTo(Mountain o) {
			return Integer.compare(minX, o.minX);
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Mountain> al = new ArrayList<>();
		ArrayDeque<Integer> us = new ArrayDeque<>();
		ArrayDeque<Integer> ds = new ArrayDeque<>();
		int sy = 0;
		int ly = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (sy == 0) {
				sy = y;
			}
			// 아래서 위
			if (ly < 0 && y > 0) {
				us.offer(x);
			}
			// 위서 아래
			else if (ly > 0 && y < 0) {
				// 올라온 기록이 있으면
				if (!us.isEmpty()) {
					int lx = us.poll();
					Mountain temp = new Mountain(Math.min(lx, x), Math.max(lx, x));
					al.add(temp);
				}
				// 없으면
				else {
					ds.offer(x);
				}
			} else if (i == N - 1) {
				if ((sy > 0 && ly < 0) && !ds.isEmpty()) {
					int lx = ds.poll();
					Mountain temp = new Mountain(Math.min(lx, x), Math.max(lx, x));
					al.add(temp);
				} else if ((sy < 0 && ly > 0) && !us.isEmpty()) {
					int lx = us.poll();
					Mountain temp = new Mountain(Math.min(lx, x), Math.max(lx, x));
					al.add(temp);
				}
			}
			ly = y;
		}
		if (!us.isEmpty() && !ds.isEmpty()) {
			int x1 = us.poll();
			int x2 = ds.poll();
			Mountain temp = new Mountain(Math.min(x1, x2), Math.max(x1, x2));
			al.add(temp);
		}
		Collections.sort(al);
		int cnt1 = 0, cnt2 = 1;
		if (al.size() == 1) {
			cnt1 = 1;
		} else {
			int lx = -Integer.MAX_VALUE;
			for (int i = 0; i < al.size(); i++) {
				Mountain cur = al.get(i);
				if (cur.minX > lx) {
					cnt1++;
					lx = cur.maxX;
				}
				if (i < al.size() - 1) {
					if (al.get(i + 1).minX > cur.maxX)
						cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}
}