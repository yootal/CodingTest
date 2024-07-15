import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }
        solve(0);
        System.out.println("NO");
    }

    static void solve(int cnt) {
        if (cnt == 3) {
            if (check()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = 'O';
                    solve(cnt + 1);
                    board[i][j] = 'X';
                }
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'T') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'S')
                            return false;
                        if (board[k][j] == 'O')
                            break;
                    }
                    for (int k = i + 1; k < N; k++) {
                        if (board[k][j] == 'S')
                            return false;
                        if (board[k][j] == 'O')
                            break;
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'S')
                            return false;
                        if (board[i][k] == 'O')
                            break;
                    }
                    for (int k = j + 1; k < N; k++) {
                        if (board[i][k] == 'S')
                            return false;
                        if (board[i][k] == 'O')
                            break;
                    }
                }
            }
        }
        return true;
    }
}