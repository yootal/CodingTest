import java.io.*;

public class Main {
    static int ans;
    static int[] num;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                check[i] = true;
                check[i] = dfs(i, 1, num[i]);
            }
        }
        System.out.println(ans);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (check[i])
                sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    static boolean dfs(int parent, int cnt, int cur) {
        if (parent == cur && cnt > 0) {
            ans += cnt;
            return true;
        }
        if (!check[cur]) {
            check[cur] = true;
            return check[cur] = dfs(parent, cnt + 1, num[cur]);
        }
        return false;
    }
}