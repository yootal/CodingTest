import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int c = 1; c <= t; c++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if ((m & ((1 << n) - 1)) == ((1 << n) - 1)) {
				sb.append("#").append(c).append(" ").append("ON").append("\n");
			} else {
				sb.append("#").append(c).append(" ").append("OFF").append("\n");
			}
		}
		System.out.print(sb);
	}

}