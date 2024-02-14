import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int ans;
	static boolean[] check_col;
	static boolean[] check1;
	static boolean[] check2;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check_col = new boolean[N];
		check1 = new boolean[2 * N - 1];
		check2 = new boolean[2 * N - 1];
		ans = 0;
		n_queen(0);
		System.out.println(ans);
	}

	static void n_queen(int row) {
		if (row == N) {
			ans++;
			return;
		}
		for (int col = 0; col < N; col++) {
			if (!check_col[col] && !check1[row + col] && !check2[col - row + (N - 1)]) {
				check_col[col] = true;
				check1[row + col] = true;
				check2[col - row + (N - 1)] = true;
				n_queen(row + 1);
				check_col[col] = false;
				check1[row + col] = false;
				check2[col - row + (N - 1)] = false;
			}
		}
	}
}