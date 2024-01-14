import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 덱에 값이 있고 마지막 값보다 현재 값이 크면
			while (!dq.isEmpty() && dq.getLast().value > num) {
				dq.removeLast();
			}
			dq.addLast(new Node(num, i));
			// 범위에서 벗어났으면 제거
			if (dq.getFirst().index <= i - L) {
				dq.removeFirst();
			}
			sb.append(dq.getFirst().value).append(" ");
		}
		System.out.println(sb);
	}

	static class Node {
		public int value;
		public int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}