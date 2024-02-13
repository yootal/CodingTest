import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new Meeting(a, b));
		}
		int ans = 1;
		int last = pq.poll().en;
		while (!pq.isEmpty()) {
			while (!pq.isEmpty() && pq.peek().st < last) {
				pq.poll();
			}
			if (pq.isEmpty())
				break;
			last = pq.poll().en;
			ans++;
		}
		System.out.println(ans);
	}

	static class Meeting implements Comparable<Meeting> {
		int st, en;

		public Meeting(int st, int en) {
			this.st = st;
			this.en = en;
		}

		@Override
		public int compareTo(Meeting o) {
			return en == o.en ? st - o.st : en - o.en;
		}
	}
}