import java.io.*;
import java.util.*;

public class Main {
	static int[][] board = new int[9][9];
	static boolean[] check;
	static ArrayList<int[]> al;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		al = new ArrayList<>();
		sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			String row = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = (int) (row.charAt(j) - '0');
				if (board[i][j] == 0)
					al.add(new int[] { i, j });
			}
		}
		sudoku(0);
	}

	static void sudoku(int idx) {
		if (idx == al.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		int[] cur = al.get(idx);
		ArrayList<Integer> num = possible(cur[0], cur[1]);
		for (int x : num) {
			board[cur[0]][cur[1]] = x;
			sudoku(idx + 1);
			board[cur[0]][cur[1]] = 0;

		}

	}

	static ArrayList<Integer> possible(int x, int y) {
		check = new boolean[10];
		for (int i = 0; i < 9; i++) {
			check[board[x][i]] = true;
		}
		for (int i = 0; i < 9; i++) {
			check[board[i][y]] = true;
		}

		x /= 3;
		y /= 3;

		for (int i = x * 3; i < (x + 1) * 3; i++) {
			for (int j = y * 3; j < (y + 1) * 3; j++) {
				check[board[i][j]] = true;
			}
		}

		ArrayList<Integer> num = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			if (!check[i])
				num.add(i);
		}
		return num;
	}
}