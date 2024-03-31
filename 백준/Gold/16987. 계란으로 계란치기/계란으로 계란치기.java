import java.io.*;
import java.util.*;

public class Main {
	static int n, ans, cnt;
	static Egg eggs[];

	static class Egg {
		int s, w;

		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		eggs = new Egg[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(s, w);
		}
		ans = 0;
		cnt = 0;
		solve(0);
		System.out.println(ans);
	}

	static void solve(int idx) {
		if (idx == n || cnt == n) {
			ans = Math.max(ans, cnt);
			return;
		}
		if (eggs[idx].s < 1) {
			solve(idx + 1);
		} else {
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (i == idx)
					continue;
				if (eggs[i].s > 0) {
					eggs[idx].s -= eggs[i].w;
					eggs[i].s -= eggs[idx].w;
					if (eggs[idx].s <= 0)
						cnt++;
					if (eggs[i].s <= 0)
						cnt++;
					flag = true;
					solve(idx + 1);
					if (eggs[idx].s <= 0)
						cnt--;
					if (eggs[i].s <= 0)
						cnt--;
					eggs[idx].s += eggs[i].w;
					eggs[i].s += eggs[idx].w;
				}
			}
			if (!flag)
				solve(idx + 1);
		}
	}
}