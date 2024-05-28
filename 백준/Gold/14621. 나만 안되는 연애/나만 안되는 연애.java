import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int find(int[] arr, int x) {
        if (arr[x] == x) return x;
        arr[x] = find(arr, arr[x]);
        return arr[x];
    }

    static boolean union(int[] arr, int x, int y) {
        int xx = find(arr, x);
        int yy = find(arr, y);

        if(xx == yy) return true;

        arr[xx] = yy;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] uni = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            uni[i] = st.nextToken().equals("M");
        }

        int u, v, d;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (uni[u] ^ uni[v]) {
                pq.add(new int[]{u, v, d});
            }
        }


        int cnt = 0, sum = 0;
        int[] check = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            check[i] = i;
        }
        int[] curr;
        while(!pq.isEmpty() && cnt < n-1){
            curr = pq.poll();
            if(!union(check, curr[0], curr[1])) {
                cnt++;
                sum += curr[2];
            }
        }

        if (cnt == n - 1) {
            System.out.println(sum);
        } else System.out.println(-1);
    }
}