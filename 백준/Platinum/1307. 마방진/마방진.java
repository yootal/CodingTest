import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];

		// N 홀수
		if (N % 2 == 1) {
			int cx = 0, cy = N / 2;
			int dx = -1, dy = 1; // 대각선
			int num = 1; // 기록할 수
			arr[cx][cy] = num++;
			for (int i = 1; i < N * N; i++) {
				int nx = cx + dx;
				int ny = cy + dy;
				while (!(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 0)) {
					if (nx < 0 && ny >= N) {
						nx = cx + 1;
						ny = cy;
					} else if (nx < 0) {
						nx = N - 1;
					} else if (ny >= N) {
						ny = 0;
					} else if (arr[nx][ny] != 0) {
						nx = cx + 1;
						ny = cy;
					}
				}
				arr[nx][ny] = num++;
				cx = nx;
				cy = ny;
			}

		}

		// N 4의 배수
		else if (N % 4 == 0) {
			int num = 1; // 기록할 수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i % 4 == j % 4 || i % 4 + j % 4 == 3) {
						arr[i][j] = num;
					}
					num++;
				}
			}
			num = 1;
			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					if (arr[i][j] == 0) {
						arr[i][j] = num;
					}
					num++;
				}
			}
		}

		// N 4의 배수가 아닌 짝수
		else {
			// 4등분 범위 나누기용 N2
			int N2 = N / 2;
			// 시작 위치
			int sx[] = { 0, N2, 0, N2 };
			int sy[] = { 0, N2, N2, 0 };
			// 4등분한 마방진 채우기 (홀수 방식)
			for (int k = 0; k < 4; k++) {
				// 가중치
				int wx = sx[k];
				int wy = sy[k];
				// 시작
				int cx = 0, cy = N2 / 2;
				int dx = -1, dy = 1;
				int num = (N2 * N2) * k + 1;
				arr[cx + wx][cy + wy] = num++;
				for (int i = 1; i < N2 * N2; i++) {
					int nx = cx + dx;
					int ny = cy + dy;
					while (!(nx >= 0 && nx < N2 && ny >= 0 && ny < N2 && arr[nx + wx][ny + wy] == 0)) {
						if (nx < 0 && ny >= N2) {
							nx = cx + 1;
							ny = cy;
						} else if (nx < 0) {
							nx = N2 - 1;
						} else if (ny >= N2) {
							ny = 0;
						} else if (arr[nx + wx][ny + wy] != 0) {
							nx = cx + 1;
							ny = cy;
						}
					}
					arr[nx + wx][ny + wy] = num++;
					cx = nx;
					cy = ny;
				}
			}
			// 1. 오른쪽 n 줄 상하 교환
			int N3 = (N2 - 1) / 2;
			int temp[][] = new int[N][N3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N3; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N3; j++) {
					arr[i][j] = temp[i + N / 2][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < N3; j++) {
					arr[i][j] = temp[i - N / 2][j];
				}
			}

			// 2. 오른쪽 두칸 상하 교환
			int N5 = N / 2 / 2;
			int N6 = N5 + N / 2;
			int temp1 = arr[N5][N3 - 1];
			int temp2 = arr[N5][N3];
			arr[N5][N3 - 1] = arr[N6][N3 - 1];
			arr[N5][N3] = arr[N6][N3];
			arr[N6][N3 - 1] = temp1;
			arr[N6][N3] = temp2;

			// 3. 왼쪽 n - 1 줄 상하 교환
			int N4 = N3 - 1;
			temp = new int[N][N4];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N4; j++) {
					temp[i][j] = arr[i][j + (N - N4)];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N4; j++) {
					arr[i][j + (N - N4)] = temp[i + N / 2][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < N4; j++) {
					arr[i][j + (N - N4)] = temp[i - N / 2][j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int row[] : arr) {
			for (int x : row) {
				sb.append(x + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}