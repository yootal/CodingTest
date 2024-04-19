import java.io.*;
import java.util.*;

public class Main {
	static int dp[][][];
	static ArrayList<Integer> num;
	static final int force[][] = { 
			{ 1, 2, 2, 2, 2 }, 
			{ 2, 1, 3, 4, 3 }, 
			{ 2, 3, 1, 3, 4 }, 
			{ 2, 4, 3, 1, 3 },
			{ 2, 3, 4, 3, 1 } 
			};

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new ArrayList<>();
		while (st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur == 0)
				break;
			num.add(cur);
		}
		dp = new int[100000][5][5];
		dance(0, 0, 0);
		System.out.println(dp[0][0][0]);
	}

	static int dance(int idx, int x, int y) {
		if (idx == num.size())
			return 0;
		if (dp[idx][x][y] != 0)
			return dp[idx][x][y];
		int nxt = num.get(idx);
		dp[idx][x][y] = Math.min(dance(idx + 1, x, nxt) + force[y][nxt], dance(idx + 1, nxt, y) + force[x][nxt]);
		return dp[idx][x][y];
	}
}