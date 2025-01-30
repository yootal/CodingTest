import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            pos.add(Integer.parseInt(st.nextToken()));
        }
        pos.add(0);
        pos.add(L);
        Collections.sort(pos);
        int ansLen = L;
        int ansPos = pos.get(1);
        int s = 1, e = L;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            int sum = 0;
            int firstCut = pos.get(1);
            // 뒤에서 부터 카운팅하는게 편함
            for (int i = pos.size() - 1; i > 0; i--) {
                sum += pos.get(i) - pos.get(i - 1);
                if (sum > mid) {
                    sum = pos.get(i) - pos.get(i - 1);
                    cnt++;
                    // 그냥 설정 길이보다 길면 길이 재조정
                    if (sum > mid) {
                        cnt = C + 1;
                        break;
                    }
                }
            }
            // sum = 처음 자른 위치, 자를 수 있는 횟수가 남으면 첫 번째 위치
            if (cnt == C) {
                firstCut = sum;
            }
            if (cnt <= C) {
                ansLen = Math.min(ansLen, mid);
                ansPos = firstCut;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(ansLen + " " + ansPos);
    }
}