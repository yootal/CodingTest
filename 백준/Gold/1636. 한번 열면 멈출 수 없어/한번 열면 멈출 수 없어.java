import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] range = new int[N][2];
        int[][] selectRange = new int[N][2];
        int[] select = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            range[i][0] = Integer.parseInt(st.nextToken());
            range[i][1] = Integer.parseInt(st.nextToken());
        }
        // 다음 범위의 시작이 현재 범위의 마지막보다 클 때
        if (range[0][1] < range[1][0]) {
            selectRange[0][0] = selectRange[0][1] = range[0][1];
        }
        // 다음 범위의 끝이 현재 범위의 시작보다 작을 때
        else if (range[0][0] > range[1][1]) {
            selectRange[0][0] = selectRange[0][1] = range[0][0];
        }
        // 현재 범위의 끝과 다음 범위의 시작이 겹칠 때
        else if (range[0][0] < range[1][0] && range[0][1] < range[1][1]) {
            selectRange[0][0] = range[1][0];
            selectRange[0][1] = range[0][1];
        }
        // 현재 범위의 시작과 다음 범위의 끝이 겹칠 때
        else if (range[0][0] > range[1][0] && range[0][1] > range[1][1]) {
            selectRange[0][0] = range[0][0];
            selectRange[0][1] = range[1][1];
        }
        // 다음 범위가 현재 범위에 포함될 때
        else if (range[0][0] <= range[1][0] && range[0][1] >= range[1][1]) {
            selectRange[0][0] = range[1][0];
            selectRange[0][1] = range[1][1];
        }
        // 현재 범위가 다음 범위에 포함될 때
        else {
            selectRange[0][0] = range[0][0];
            selectRange[0][1] = range[0][1];
        }
        int sum = 0;
        for (int i = 1; i < N; i++) {
            if (selectRange[i - 1][1] < range[i][0]) {
                sum += range[i][0] - selectRange[i - 1][1];
                selectRange[i][0] = selectRange[i][1] = range[i][0];
            } else if (selectRange[i - 1][0] > range[i][1]) {
                sum += selectRange[i - 1][0] - range[i][1];
                selectRange[i][0] = selectRange[i][1] = range[i][1];
            } else if (selectRange[i - 1][0] < range[i][0] && selectRange[i - 1][1] < range[i][1]) {
                selectRange[i][0] = range[i][0];
                selectRange[i][1] = selectRange[i - 1][1];
            } else if (selectRange[i - 1][0] > range[i][0] && selectRange[i - 1][1] > range[i][1]) {
                selectRange[i][0] = selectRange[i - 1][0];
                selectRange[i][1] = range[i][1];
            } else if (selectRange[i - 1][0] <= range[i][0] && selectRange[i - 1][1] >= range[i][1]) {
                selectRange[i][0] = range[i][0];
                selectRange[i][1] = range[i][1];
            } else {
                selectRange[i][0] = selectRange[i - 1][0];
                selectRange[i][1] = selectRange[i - 1][1];
            }
        }
        int temp = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (selectRange[i][0] == selectRange[i][1]) {
                select[i] = selectRange[i][0];
                temp = selectRange[i][0];
            } else if (i == N - 1) {
                select[i] = selectRange[i][0];
                temp = selectRange[i][0];
            } else if (selectRange[i + 1][1] < selectRange[i][0]) {
                select[i] = selectRange[i][0];
                temp = selectRange[i][0];
            } else if (selectRange[i + 1][0] > selectRange[i][1]) {
                select[i] = selectRange[i][1];
                temp = selectRange[i][1];
            } else {
                select[i] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        for (int s : select) sb.append(s).append("\n");
        System.out.println(sb);
    }
}