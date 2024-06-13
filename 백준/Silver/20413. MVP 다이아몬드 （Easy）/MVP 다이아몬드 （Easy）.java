import java.io.*;
import java.util.*;

class Main {
	static int s, g, p, d;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		String mvp = br.readLine();
		int score[] = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			char cur = mvp.charAt(i);
			if (i == 0) {
				int v = calc(cur);
				score[i] = v;
			} else {
				int v = calc(cur);
				if (v != d)
					score[i] = v - score[i - 1];
				else
					score[i] = d;
			}
			ans += score[i];
		}
		System.out.println(ans);
	}

	static int calc(char c) {
		switch (c) {
		case 'B':
			return s - 1;
		case 'S':
			return g - 1;
		case 'G':
			return p - 1;
		case 'P':
			return d - 1;
		default:
			return d;
		}

	}
}