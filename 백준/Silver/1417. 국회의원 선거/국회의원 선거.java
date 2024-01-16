import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int dasom = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int ans = 0;
		while (!pq.isEmpty() && pq.peek() >= dasom) {
			int top = pq.poll();
			pq.add(--top);
			dasom++;
			ans++;
		}
		System.out.println(ans);
	}

}