import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		map.put("kor", 1);
		map.put("eng", 2);
		map.put("math", 3);
		map.put("apple", 1);
		map.put("pear", 2);
		map.put("orange", 3);
		map.put("red", 1);
		map.put("blue", 2);
		map.put("green", 3);
		map.put("-", 0);
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = map.get(st.nextToken());
			int b = map.get(st.nextToken());
			int c = map.get(st.nextToken());

			if (!map2.containsKey(a * 100 + b * 10 + c)) {
				map2.put(a * 100 + b * 10 + c, 0);
			}
			map2.put(a * 100 + b * 10 + c, map2.get(a * 100 + b * 10 + c) + 1);

			if (!map2.containsKey(0 * 100 + b * 10 + c)) {
				map2.put(0 * 100 + b * 10 + c, 0);
			}
			map2.put(0 * 100 + b * 10 + c, map2.get(0 * 100 + b * 10 + c) + 1);

			if (!map2.containsKey(a * 100 + 0 * 10 + c)) {
				map2.put(a * 100 + 0 * 10 + c, 0);
			}
			map2.put(a * 100 + 0 * 10 + c, map2.get(a * 100 + 0 * 10 + c) + 1);

			if (!map2.containsKey(a * 100 + b * 10 + 0)) {
				map2.put(a * 100 + b * 10 + 0, 0);
			}
			map2.put(a * 100 + b * 10 + 0, map2.get(a * 100 + b * 10 + 0) + 1);

			if (!map2.containsKey(0 * 100 + 0 * 10 + c)) {
				map2.put(0 * 100 + 0 * 10 + c, 0);
			}
			map2.put(0 * 100 + 0 * 10 + c, map2.get(0 * 100 + 0 * 10 + c) + 1);

			if (!map2.containsKey(a * 100 + 0 * 10 + 0)) {
				map2.put(a * 100 + 0 * 10 + 0, 0);
			}
			map2.put(a * 100 + 0 * 10 + 0, map2.get(a * 100 + 0 * 10 + 0) + 1);

			if (!map2.containsKey(0 * 100 + b * 10 + 0)) {
				map2.put(0 * 100 + b * 10 + 0, 0);
			}
			map2.put(0 * 100 + b * 10 + 0, map2.get(0 * 100 + b * 10 + 0) + 1);

			if (!map2.containsKey(0 * 100 + 0 * 10 + 0)) {
				map2.put(0 * 100 + 0 * 10 + 0, 0);
			}
			map2.put(0 * 100 + 0 * 10 + 0, map2.get(0 * 100 + 0 * 10 + 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = map.get(st.nextToken());
			int b = map.get(st.nextToken());
			int c = map.get(st.nextToken());
			if (!map2.containsKey(a * 100 + b * 10 + c)) {
				map2.put(a * 100 + b * 10 + c, 0);
			}
			sb.append(map2.get(a * 100 + b * 10 + c)).append("\n");
		}
		System.out.print(sb);
	}
}