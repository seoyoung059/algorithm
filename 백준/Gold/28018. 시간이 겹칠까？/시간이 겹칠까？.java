import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seats = new int[1_000_002];

//        int[][] arr = new int[n][2];
        StringTokenizer st; int s, e;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            seats[s]++; seats[e+1]--;
        }

        for (int i = 1; i < 1_000_001; i++) {
            seats[i] += seats[i-1];
        }

        int q = Integer.parseInt(br.readLine());
//        int[] qArr = new int[q];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
//            qArr[i] = Integer.parseInt(st.nextToken());
//            System.out.println(seats[Integer.parseInt(st.nextToken())]);
            sb.append(seats[Integer.parseInt(st.nextToken())]).append("\n");
        }
        System.out.print(sb);

    }
}