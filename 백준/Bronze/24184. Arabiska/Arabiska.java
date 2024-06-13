import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String word = st.nextToken();
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (set.contains(c)) {
					if (j < word.length() - 2) {
						boolean flag = false;
						for (int k = j + 1; k <= j + 2; k++) {
							if (set.contains(word.charAt(k))) {
								flag = true;
								break;
							}
						}
						if (flag) {
							sb.insert(0, c);
						}
					} else
						sb.insert(0, c);
				} else
					sb.insert(0, c);
			}
			if (i != N - 1)
				sb.insert(0, " ");
		}
		System.out.println(sb);
	}
}