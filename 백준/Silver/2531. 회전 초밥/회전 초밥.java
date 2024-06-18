import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()) - 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }


        int[] check = new int[d];
        int var = 0, answer = 0;
        boolean use = false;

        for (int i = 0; i < k; i++) {
            if (check[arr[i]] == 0) var++;
            check[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, var + ((check[c] == 0) ? 1 : 0));

            check[arr[i]]--;
            if (check[arr[i]] == 0) var--;
            if (check[arr[(i + k) % n]] == 0) var++;
            check[arr[(i + k) % n]]++;
        }
        System.out.println(answer);
    }

}