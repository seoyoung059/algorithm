import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int n;

    static void cntSort(int[] arr) {
        int[] cnt = new int[2_000_001];
        for (int i = 0; i < n; i++) {
            cnt[arr[i]+1_000_000]++;
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            while(cnt[idx]==0){
                idx++;
            }
            arr[i] = idx-1_000_000;
            idx++;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        
        cntSort(arr);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

}