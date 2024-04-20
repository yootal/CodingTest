import java.io.*;
import java.util.*;

public class Main {
	static int seq[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[N];
		int record[] = new int[N];
		seq = new int[1000001];
		seq[0] = -Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (seq[idx] < num[i]) {
				seq[++idx] = num[i];
				record[i] = idx;
			} else {
				int cur = lower_idx(num[i], idx);
				record[i] = cur;
				seq[cur] = num[i];
			}
		}
		int ans[] = new int[idx];
		int cnt = idx;
		for (int i = N - 1; i >= 0; i--) {
			if (record[i] == cnt) {
				cnt--;
				ans[cnt] = num[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(idx).append("\n");
		for (int v : ans) {
			sb.append(v).append(" ");
		}
		System.out.print(sb);
	}

	static int lower_idx(int x, int ed) {
		int st = 0;
		int mid = 0;
		while (st < ed) {
			mid = (st + ed) / 2;
			if (x <= seq[mid]) {
				ed = mid;
			} else {
				st = mid + 1;
			}
		}
		return st;
	}
}