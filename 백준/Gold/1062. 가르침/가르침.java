import java.util.*;
import java.io.*;

class Main {
	static int N, K, ans;
	static String words[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		String init = "antic";
		int flag = 0;
		for (int i = 0; i < 5; i++) {
			flag |= 1 << init.charAt(i) - 'a';
		}
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		ans = 0;
		if (K == 26)
			ans = N;
		else if (K >= 5) {
			solve(0, flag, 5);
		}
		System.out.println(ans);
	}

	static void solve(int idx, int flag, int cnt) {
		if (cnt == K) {
			int wordCount = 0;
			for (int i = 0; i < N; i++) {
				boolean ansCheck = true;
				for (int j = 4; j < words[i].length() - 4; j++) {
					if ((flag & 1 << (words[i].charAt(j) - 'a')) == 0) {
						ansCheck = false;
						break;
					}
				}
				if (ansCheck)
					wordCount++;
			}
			ans = Math.max(ans, wordCount);
			return;
		}
		for (int i = idx; i < 26; i++) {
			if ((flag & (1 << i)) == 0) {
				solve(i + 1, flag | (1 << i), cnt + 1);
			}
		}
	}
}