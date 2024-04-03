import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int sol(BufferedReader br) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][8];
        int[] top  = new int[4];
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num, dir, left, right, tmp, td;
        int[] move = new int[4];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken())-1;
            dir = Integer.parseInt(st.nextToken());
            move[num] = dir;

            tmp = num; td = dir;
            left = arr[tmp][(top[tmp]+6)%8];
            while(tmp-1>=0){
                if(left == arr[tmp-1][(top[tmp-1]+2)%8]) break;
                move[tmp-1] = -td;
                tmp--;
                left = arr[tmp][(top[tmp]+6)%8];
                td = -td;
            }


            tmp = num; td = dir;
            right = arr[tmp][(top[tmp]+2)%8];
            while(tmp+1<4){
                if(right == arr[tmp+1][(top[tmp+1]+6)%8]) break;
                move[tmp+1] = -td;
                tmp++;
                right = arr[tmp][(top[tmp]+2)%8];
                td = -td;
            }


            for (int j = 0; j < 4; j++) {
                if(move[j]==1) {
                    top[j] = (top[j]+7)%8;
                }
                else if(move[j]==-1){
                    top[j] = (top[j]+1)%8;
                }
                move[j] = 0;
            }

//            System.out.println(Arrays.toString(top));
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += (arr[i][top[i]]==1)?(int)Math.pow(2, i):0;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            sb.append("#").append(tc+1).append(" ").append(sol(br)).append("\n");
        }
        System.out.println(sb);
    }
}