import java.io.*;
import java.util.*;

public class Main {
	static int[] cnt = new int[4];
	static int ans = 0;
	static int a;
	static int c;
	static int g;
	static int t;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String dna = new String(br.readLine());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < P; i++) {
			count_up(dna.charAt(i));
		}
		count_ans();
		for (int i = 0; i < S - P; i++) {
			count_down(dna.charAt(i));
			count_up(dna.charAt(i + P));
			count_ans();
		}
		System.out.println(ans);
	}

	public static void count_up(char c) {
		if (c == 'A') {
			cnt[0]++;
		} else if (c == 'C') {
			cnt[1]++;
		} else if (c == 'G') {
			cnt[2]++;
		} else {
			cnt[3]++;
		}
	}

	public static void count_down(char c) {
		if (c == 'A') {
			cnt[0]--;
		} else if (c == 'C') {
			cnt[1]--;
		} else if (c == 'G') {
			cnt[2]--;
		} else {
			cnt[3]--;
		}
	}

	public static void count_ans() {
		if (a <= cnt[0] && c <= cnt[1] && g <= cnt[2] && t <= cnt[3]) {
			ans++;
		}
	}
}