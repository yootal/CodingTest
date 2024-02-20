import java.io.*;
import java.util.*;

public class Main {
	static String vowel = "aeiou";
	static String[] inp, ans;
	static int L, C;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		inp = new String[C];
		ans = new String[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			inp[i] = st.nextToken();
		}
		Arrays.sort(inp);
		comb(0, 0, 0);
		System.out.print(sb);

	}

	static void comb(int cnt, int idx, int vCnt) {
		if (cnt == L) {
			if (vCnt > 0 && L - vCnt >= 2) {
				sb.append(String.join("", ans)).append("\n");
			}
			return;
		}
		for (int i = idx; i < C; i++) {
			ans[cnt] = inp[i];
			if (vowel.contains(inp[i]))
				comb(cnt + 1, i + 1, vCnt + 1);
			else
				comb(cnt + 1, i + 1, vCnt);
		}
	}
}