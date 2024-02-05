import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> al;
		ArrayList<Integer> temp;
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			al = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens())
				al.add(Integer.parseInt(st.nextToken()));
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				temp = new ArrayList<>();
				for (int i = 0; i < y; i++) {
					temp.add(Integer.parseInt(st.nextToken()));
				}
				al.addAll(x, temp);
			}
			sb.append("#").append(tc + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(al.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}