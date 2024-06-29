import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Main {
	static String[] parent;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			map.put(A, B);
		}
		st = new StringTokenizer(br.readLine());
		String A1 = st.nextToken();
		String B1 = st.nextToken();
		String temp = B1;
		int ans = 0;
		while (!(map.get(temp) == null)) {
			temp = map.get(temp);
			if (temp.equals(A1))
				ans = 1;
		}
		temp = A1;
		while (!(map.get(temp) == null)) {
			temp = map.get(temp);
			if (temp.equals(B1))
				ans = 1;
		}
		System.out.println(ans);
	}
}