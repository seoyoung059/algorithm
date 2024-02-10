import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] answer = new int[k+1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        answer[0]=0;
        int tmp;
        for (int i = 1; i < k+1; i++) {
            answer[i]=Integer.MAX_VALUE;
            for (int c = n-1; c >= 0; c--) {
                tmp = i-coin[c];
                if(tmp>=0 && answer[tmp]>=0){
                    answer[i] = Math.min(answer[i], answer[tmp]+1);
                }
            }
            if(answer[i] == Integer.MAX_VALUE) answer[i]=-1;
        }
        System.out.println(answer[k]);
    }
}