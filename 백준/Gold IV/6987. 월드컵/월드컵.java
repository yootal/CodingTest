import java.io.*;
import java.util.*;

public class Main {
	static boolean ans;
	static int[][] result;
	static int[][] select;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			result = new int[6][3];
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					result[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			ans = false;
			select = new int[6][3];
			check(0, 1);
			sb.append(ans ? 1 : 0).append(" ");
		}
		System.out.println(sb);
	}

	static void check(int who, int other) {
		if (who == 5) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (select[i][j] != result[i][j])
						return;
				}
			}
			ans = true;
			return;
		}
		if (other == 6) {
			check(who + 1, who + 2);
			return;
		}
		if (select[who][0] < result[who][0] && select[other][2] < result[other][2]) {
			select[who][0]++;
			select[other][2]++;
			check(who, other + 1);
			select[who][0]--;
			select[other][2]--;
		}
		if (select[other][0] < result[other][0] && select[who][2] < result[who][2]) {
			select[other][0]++;
			select[who][2]++;
			check(who, other + 1);
			select[other][0]--;
			select[who][2]--;
		}
		if (select[other][1] < result[other][1] && select[who][1] < result[who][1]) {
			select[other][1]++;
			select[who][1]++;
			check(who, other + 1);
			select[other][1]--;
			select[who][1]--;
		}
	}
}