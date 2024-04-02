import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static class FenwickTree {
        long[] tree;
        long n;

        FenwickTree(int n) {
            this.tree = new long[n+1];
            this.n = n;
        }

        public void update(int i, long diff) {
            while(i<=this.n) {
                this.tree[i]+=diff;
                i += (i&-i);
            }
        }

        public long sum(int i) {
            long answer = 0;
            while(i>0){
                answer+=this.tree[i];
                i -= (i&-i);
            }
            return answer;
        }

        public long prefixSum(int i, int j){
            return sum(j)-sum(i-1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        FenwickTree ft = new FenwickTree(n);
        long[] arr = new long[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
            ft.update(i, arr[i]);
        }


        StringBuilder sb = new StringBuilder();
        long tmp;
        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            switch (a){
                case 1:
                    int b1 = Integer.parseInt(st.nextToken());
                    long c1 = Long.parseLong(st.nextToken());
                    tmp = c1-arr[b1];
                    arr[b1] = c1;
                    ft.update(b1, tmp);
                    break;
                case 2:
                    int b2 = Integer.parseInt(st.nextToken());
                    int c2 = Integer.parseInt(st.nextToken());

                    sb.append(ft.prefixSum(b2, c2)).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}