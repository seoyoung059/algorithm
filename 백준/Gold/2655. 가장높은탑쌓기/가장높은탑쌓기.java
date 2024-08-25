import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Block implements Comparable<Block> {
        int size;
        int height;
        int weight;
        int num;

        Block(int size, int height, int weight, int num) {
            this.size = size;
            this.height = height;
            this.weight = weight;
            this.num = num;
        }

        @Override
        public int compareTo(Block o) {
            return o.weight - weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Block[] blocks = new Block[n+1];
        StringTokenizer st;
        int s, h, w;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            blocks[i] = new Block(s, h, w, i+1);
        }
        blocks[n] = new Block(Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0);

        Arrays.sort(blocks);

//        for (int i = 0; i < n+1; i++) {
//            System.out.println(blocks[i]);
//        }

        int[][] dp = new int[n+1][3];
        int ans = -1, idx = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
//                System.out.println(blocks[i].size+" "+blocks[j].size);
                if (blocks[i].size > blocks[j].size) continue;
                if(dp[i][0] < blocks[i].height+dp[j][0]){
                    dp[i][0] = blocks[i].height+dp[j][0];
                    dp[i][1] = j;
                    dp[i][2] = dp[j][2]+1;
                }
                if (ans < dp[i][0]) {
                    ans = dp[i][0];
                    idx = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[idx][2]).append('\n');
        sb.append(blocks[idx].num).append('\n');
        while(blocks[dp[idx][1]].num!=0){
            sb.append(blocks[dp[idx][1]].num).append('\n');
            idx = dp[idx][1];
        }

        System.out.print(sb);
    }
}