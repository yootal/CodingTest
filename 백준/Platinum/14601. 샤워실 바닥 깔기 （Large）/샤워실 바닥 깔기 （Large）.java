import java.io.*;
import java.util.*;

class Main {
	static int board[][];
	static int num;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		// 좌표 변환
		y -= 1;
		x = (1 << N) - x;
		board = new int[1 << N][1 << N];
		board[x][y] = -1;
		num = 1;
		tile(N, 0, 0, x, y);
		StringBuilder sb = new StringBuilder();
		for (int row[] : board) {
			for (int v : row) {
				sb.append(v + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void tile(int n, int sr, int sc, int xr, int xc) {
		if (n == 0) { // 재귀 종료
			return;
		} else {
			int half = 1 << (n - 1); // 절반 길이
			// 중앙 좌표 4가지 구하기
			int mr = sr + half;
			int mc = sc + half;
			int xr1 = mr - 1, xc1 = mc - 1;
			int xr2 = mr - 1, xc2 = mc;
			int xr3 = mr, xc3 = mc - 1;
			int xr4 = mr, xc4 = mc;
			// 찾고자 하는 값이 사분면에 든다면 중앙의 나머지 3부분을 칠하고 찾고자 하는 값 갱신
			if (xr < mr && xc < mc) {
				center3(mr, mc, 1);
				xr1 = xr;
				xc1 = xc;
			} else if (xr < mr && xc >= mc) {
				center3(mr, mc, 2);
				xr2 = xr;
				xc2 = xc;
			} else if (xr >= mr && xc < mc) {
				center3(mr, mc, 3);
				xr3 = xr;
				xc3 = xc;
			} else if (xr >= mr && xc >= mc) {
				center3(mr, mc, 4);
				xr4 = xr;
				xc4 = xc;
			}
			// 찾고자 하는 값이 없는 사분면은 나머지 세부분을 칠하도록 재귀
			// 있는 사분면은 그대로 재귀
			tile(n - 1, sr, sc, xr1, xc1);
			tile(n - 1, sr, mc, xr2, xc2);
			tile(n - 1, mr, sc, xr3, xc3);
			tile(n - 1, mr, mc, xr4, xc4);
		}
	}

	static void center3(int mr, int mc, int part) {
		if (part != 1) {
			board[mr - 1][mc - 1] = num;
		}
		if (part != 2) {
			board[mr - 1][mc] = num;
		}
		if (part != 3) {
			board[mr][mc - 1] = num;
		}
		if (part != 4) {
			board[mr][mc] = num;
		}
		num++;
	}
}