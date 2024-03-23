import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(br.readLine());
		StringTokenizer st = new StringTokenizer(sb.reverse().toString());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				dq.addFirst(i);
			} else if (cmd == 2) {
				int temp = dq.removeFirst();
				dq.addFirst(i);
				dq.addFirst(temp);
			} else {
				dq.addLast(i);
			}
		}
		sb = new StringBuilder();
		for (int x : dq) {
			sb.append(x + " ");
		}
		System.out.print(sb);
	}
}