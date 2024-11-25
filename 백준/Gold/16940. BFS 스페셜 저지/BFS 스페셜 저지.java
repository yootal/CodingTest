import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] dep = new int[N + 1];
        ArrayList<Integer> depthSize = new ArrayList<>();
        Arrays.fill(dep, -1);
        int[] parent = new int[N + 1];
        int[] childCnt = new int[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        dep[1] = 0;
        int depth = 1;
        int size = 1;
        int cnt = 0;
        depthSize.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (dep[nxt] == -1) {
                    dep[nxt] = depth;
                    childCnt[cur]++;
                    parent[nxt] = cur;
                    q.offer(nxt);
                    cnt++;
                    if (size == cnt) {
                        depthSize.add(cnt);
                        depth++;
                        cnt = 0;
                        size = q.size();
                    }
                }
            }
        }
        childCnt[0] = 1;
        parent[1] = 0;
        st = new StringTokenizer(br.readLine());
        int count = 0;
        int cntD = 0;
        int curD = 0;
        int curP = 0;
        int sizeP = 0;
        ArrayDeque<Integer> parentQ = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            parentQ.offer(cur);
            if (curP != parent[cur]) {
                break;
            }
            sizeP++;
            if (childCnt[curP] == sizeP && !parentQ.isEmpty()) {
                while (!parentQ.isEmpty() && childCnt[parentQ.peek()] == 0) {
                    parentQ.poll();
                }
                if (!parentQ.isEmpty()) {
                    curP = parentQ.poll();
                    count += sizeP;
                    cntD += sizeP;
                    sizeP = 0;
                }
            }
            if (curD < depthSize.size() && depthSize.get(curD) == cntD) {
                curD++;
                cntD = 0;
            } else if (dep[cur] < curD) {
                break;
            }
            if (i == N - 1) {
                count += sizeP;
                break;
            }
        }
        System.out.println(count == N ? 1 : 0);
    }
}