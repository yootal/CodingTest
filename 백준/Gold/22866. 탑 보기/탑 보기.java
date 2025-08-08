import java.io.*;
import java.util.*;

public class Main {
    static class Tower {
        int size = 0, idx = Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        Tower[] left = new Tower[N];
        Tower[] right = new Tower[N];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            left[i] = new Tower();
            while (!stack.isEmpty() && stack.peek()[1] <= height[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i].size = stack.size();
                left[i].idx = stack.peek()[0];
            }
            stack.push(new int[]{i, height[i]});
        }
        stack.clear();
        stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            right[i] = new Tower();
            while (!stack.isEmpty() && stack.peek()[1] <= height[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i].size = stack.size();
                right[i].idx = stack.peek()[0];
            }
            stack.push(new int[]{i, height[i]});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (left[i].size + right[i].size > 0) {
                sb.append(left[i].size + right[i].size).append(" ");
                int distLeft = Math.abs(i - left[i].idx);
                int distRight = Math.abs(i - right[i].idx);
                if (distLeft <= distRight) {
                    sb.append(left[i].idx + 1).append("\n");
                } else {
                    sb.append(right[i].idx + 1).append("\n");
                }
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}