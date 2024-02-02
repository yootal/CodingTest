import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayDeque<Integer> q;
		for (int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			q = new ArrayDeque<>();
			while (st.hasMoreTokens()) {
				q.offerLast(Integer.parseInt(st.nextToken()));
			}
			int value = 1;
			while (true) {
				int num = q.pollFirst() - value;
				if (num <= 0) {
					q.offerLast(0);
					break;
				}
				q.offerLast(num);
				if (value == 5) {
					value = 1;
				} else
					value++;
			}
			sb.append("#").append(n).append(" ");
			for (int x : q) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

}