import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String>[] first = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			first[i] = new ArrayList<>();
		}
		HashMap<String, Integer> map = new HashMap<>();
		String words[] = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			if (!map.containsKey(words[i]))
				map.put(words[i], i);
		}
		int maxLen = 0;
		int maxIdx = 20000;
		StringBuilder sb = new StringBuilder();
		sb.append(words[0]).append("\n");
		sb.append(words[1]);
		for (int i = 0; i < N; i++) {
			String cur = words[i];
			char c = cur.charAt(0);
			for (int j = 0; j < first[c - 'a'].size(); j++) {
				String temp = first[c - 'a'].get(j);
				if (cur.equals(temp))
					continue;
				int cnt = 0;
				int len = Math.min(cur.length(), temp.length());
				for (int k = 0; k < len; k++) {
					if (cur.charAt(k) != temp.charAt(k))
						break;
					cnt++;
				}
				int curIdx = map.get(temp);
				if (maxLen < cnt || (maxLen == cnt && curIdx < maxIdx)) {
					maxLen = cnt;
					maxIdx = curIdx;
					sb = new StringBuilder();
					sb.append(temp).append("\n");
					sb.append(cur);
				}
			}
			first[c - 'a'].add(cur);
		}
		System.out.println(sb);
	}
}