import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		Node[] next = new Node[26];
		boolean isEnd;
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node root = new Node();
		while (n-- > 0) {
			String word = br.readLine();
			Node now = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (now.next[c - 'a'] == null) {
					now.next[c - 'a'] = new Node();
				}
				now = now.next[c - 'a'];
				if (i == word.length() - 1)
					now.isEnd = true;
			}
		}
		int ans = 0;
		while (m-- > 0) {
			String word = br.readLine();
			Node now = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (now.next[c - 'a'] == null) {
					break;
				}
				now = now.next[c - 'a'];
				if (i == word.length() - 1 && now.isEnd)
					ans++;
			}
		}
		System.out.println(ans);
	}
}