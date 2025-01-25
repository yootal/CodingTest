import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
            } else if (stack.peek() > y) {
                while (!stack.isEmpty() && stack.peek() > y) {
                    stack.pop();
                    count++;
                }
                if (stack.isEmpty() || stack.peek() < y) {
                    stack.push(y);
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != 0)
                count++;
        }
        System.out.println(count);
    }
}