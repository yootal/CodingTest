import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<int[]> s = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int nxt = Integer.parseInt(st.nextToken());
			while (!s.isEmpty() && s.getLast()[0] < nxt) {
				s.pollLast();
			}
			if (s.isEmpty()) {
				sb.append(0).append(" ");
			} else {
				sb.append(s.getLast()[1]).append(" ");
			}
			s.offerLast(new int[] { nxt, i });
		}
		System.out.println(sb);
	}
}