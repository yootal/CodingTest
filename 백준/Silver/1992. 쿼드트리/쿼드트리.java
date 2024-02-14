import java.io.*;

public class Main {
	static String[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		div(N, N, N);
		System.out.println(sb);
	}

	static void div(int x, int y, int len) {
		int sx = x - len;
		int sy = y - len;
		char flag = arr[sx].charAt(sy);
		if (len == 1) {
			sb.append(flag);
			return;
		}
		int nxt_len = len / 2;
		for (int i = sx; i < sx + len; i++) {
			for (int j = sy; j < sy + len; j++) {
				if (arr[i].charAt(j) != flag) {
					sb.append("(");
					div(x - nxt_len, y - nxt_len, nxt_len);
					div(x - nxt_len, y, nxt_len);
					div(x, y - nxt_len, nxt_len);
					div(x, y, nxt_len);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(flag);
	}
}