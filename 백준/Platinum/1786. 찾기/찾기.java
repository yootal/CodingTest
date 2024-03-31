import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		StringBuilder sb = new StringBuilder();
		int[] f = fail(b);
		int cnt = 0;
		int j = 0;

		for (int i = 0; i < a.length(); i++) {
			while (j > 0 && a.charAt(i) != b.charAt(j)) {
				j = f[j - 1];
			}
			if (a.charAt(i) == b.charAt(j)) {
				j++;
			}
			if (j == b.length()) {
				sb.append((i + 2 - j) + " ");
				cnt++;
				j = f[j - 1];
			}
		}

		System.out.println(cnt);
		System.out.println(sb);
	}

	static int[] fail(String s) {
		int[] f = new int[s.length()];
		int j = 0;
		for (int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = f[j - 1];
			}
			if (s.charAt(i) == s.charAt(j)) {
				j++;
				f[i] = j;
			}
		}
		return f;
	}
}