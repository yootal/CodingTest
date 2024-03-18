import java.io.*;
import java.util.*;

public class Main {
	static class Track {
		int l, r;

		public Track(int l, int r) {
			this.l = l;
			this.r = r;
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int start = Integer.MAX_VALUE;
		int end = -Integer.MAX_VALUE;
		PriorityQueue<Track> wait = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.r, o2.r));
		PriorityQueue<Track> inTrack = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.l, o2.l));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			wait.offer(new Track(a, b));
			start = Math.min(start, a);
			end = Math.max(end, b);
		}
		int ans = 0;
		int d = Integer.parseInt(br.readLine());
		while (start + d <= end) {
			while (!wait.isEmpty() && wait.peek().r <= start + d) {
				inTrack.offer(wait.poll());
			}
			while (!inTrack.isEmpty() && inTrack.peek().l < start) {
				inTrack.poll();
			}
			ans = Math.max(ans, inTrack.size());
			start++;
		}
		System.out.println(ans);
	}
}