import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int n;
	static int m;
	static int r;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
			case 1:
				arr = oper1();
				break;
			case 2:
				arr = oper2();
				break;
			case 3:
				arr = oper3();
				break;
			case 4:
				arr = oper4();
				break;
			case 5:
				arr = oper5();
				break;
			case 6:
				arr = oper6();
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int[] row : arr) {
			for (int x : row) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static int[][] oper1() {
		int[][] newArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArr[i][j] = arr[n - 1 - i][j];
			}
		}
		return newArr;
	}

	static int[][] oper2() {
		int[][] newArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArr[i][j] = arr[i][m - 1 - j];
			}
		}
		return newArr;
	}

	static int[][] oper3() {
		int[][] newArr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				newArr[i][j] = arr[n - j - 1][i];
			}
		}
		int temp = n;
		n = m;
		m = temp;
		return newArr;
	}

	static int[][] oper4() {
		int[][] newArr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				newArr[i][j] = arr[j][m - i - 1];
			}
		}
		int temp = n;
		n = m;
		m = temp;
		return newArr;
	}

	static int[][] oper5() {
		int[][] newArr = new int[n][m];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i + n / 2][j];
			}
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[i][j - m / 2];
			}
		}
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[i - n / 2][j];
			}
		}
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i][j + m / 2];
			}
		}
		return newArr;
	}

	static int[][] oper6() {
		int[][] newArr = new int[n][m];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i][j + m / 2];
			}
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[i + n / 2][j];
			}
		}
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				newArr[i][j] = arr[i][j - m / 2];
			}
		}
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				newArr[i][j] = arr[i - n / 2][j];
			}
		}
		return newArr;
	}
}