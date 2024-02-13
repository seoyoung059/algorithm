import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] w = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            w[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        sb.append(0).append(" ");
        for (int i = 2; i < n+1; i++) {
            w[i] += w[arr[i]];
            sb.append(w[i]).append(" ");
        }
        System.out.print(sb);

    }
}