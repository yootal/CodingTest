import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int len = 0;
		int[] pre = new int[n + 1];
		int[] nxt = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			pre[i] = (i == 1) ? n : i - 1;
			nxt[i] = (i == n) ? 1 : i + 1;
			len++;
		}
		int i = 1;
		int cur = 1;
		while (len != 1) {
			if (i == k) {
				pre[nxt[cur]] = pre[cur];
				nxt[pre[cur]] = nxt[cur];
				sb.append(cur).append(", ");
				len--;
				i = 1;
			} else {
				i++;
			}
			cur = nxt[cur];
		}
		sb.append(cur).append(">");
		System.out.println(sb);
	}
}