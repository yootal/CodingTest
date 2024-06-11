import java.io.*;

class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String inp = br.readLine();
		char board[][] = new char[101][101];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				board[i][j] = '#';
			}
		}
		int sx, sy, minX, minY, maxX, maxY;
		sx = sy = minX = minY = maxX = maxY = 50;
		int d = 2;
		board[sx][sy] = '.';
		for (int i = 0; i < n; i++) {
			if (inp.charAt(i) == 'F') {
				sx += dx[d];
				sy += dy[d];
				board[sx][sy] = '.';
				minX = Math.min(minX, sx);
				minY = Math.min(minY, sy);
				maxX = Math.max(maxX, sx);
				maxY = Math.max(maxY, sy);
			} else if (inp.charAt(i) == 'L') {
				if (d == 0)
					d = 3;
				else {
					d--;
				}
			} else {
				if (d == 3) {
					d = 0;
				} else {
					d++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}