import java.io.*;
import java.util.*;

public class Main {
	static int[][] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new int[26][2];
		StringTokenizer st;
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0) - 'A';
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			if (b != '.') {
				tree[a][0] = b - 'A';
			}
			if (c != '.') {
				tree[a][1] = c - 'A';
			}
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		System.out.print(sb);
	}

	static void preorder(int x) {
		sb.append((char) (x + 'A'));
		if (tree[x][0] != 0)
			preorder(tree[x][0]);
		if (tree[x][1] != 0)
			preorder(tree[x][1]);
	}

	static void inorder(int x) {
		if (tree[x][0] != 0)
			inorder(tree[x][0]);
		sb.append((char) (x + 'A'));
		if (tree[x][1] != 0)
			inorder(tree[x][1]);
	}

	static void postorder(int x) {
		if (tree[x][0] != 0)
			postorder(tree[x][0]);
		if (tree[x][1] != 0)
			postorder(tree[x][1]);
		sb.append((char) (x + 'A'));
	}
}