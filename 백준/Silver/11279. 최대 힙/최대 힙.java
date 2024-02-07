import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				} else
					sb.append(0).append("\n");
			} else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}
}