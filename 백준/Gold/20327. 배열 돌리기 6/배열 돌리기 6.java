import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int n,r;
    static void swap(int[][] arr, int y1, int x1, int y2, int x2){
        int tmp = arr[y1][x1];
        arr[y1][x1] = arr[y2][x2];
        arr[y2][x2] = tmp;
    }

    static int[] solution(int idx, int[][] input, int[] where) {
        if(idx==r) return where;
        int tmp = (1<<input[idx][1]);
        where = solution(idx+1, input, where);
        int y = where[0]; int x = where[1];
        switch (input[idx][0]){
            case 1:
                where[0] = (y/tmp*tmp +tmp -1 -y%tmp);
                where[1] = x;
                break;
            case 2:
                where[0] = y;
                where[1] = (x/tmp*tmp+tmp-1-x%tmp);
                break;
            case 3:
                //tmpArr[y][x] = arr[tmp*(i+1)-1-x][j*tmp+y];
                //arr[tmp*i+y][j*tmp+x] = tmpArr[y][x];
                where[0] = y/tmp*tmp + tmp-1-x%tmp;
                where[1] = x/tmp*tmp+y%tmp;
                break;
            case 4:
                where[1] = x/tmp*tmp + tmp-1-y%tmp;
                where[0] = y/tmp*tmp+x%tmp;
                break;
            case 5://swap(arr, i*tmp+j, m, n-(i+1)*tmp+j, m);
                where[0] = (1<<n)-(y/tmp+1)*tmp+y%tmp;
                break;
            case 6: //swap(arr, m, i*tmp+j, m, n-(i+1)*tmp+j);
                where[1] = (1<<n)-(x/tmp+1)*tmp+x%tmp;
                break;
            case 7:
                // tmpArr[tmp*i+y][tmp*j+x] = arr[((n/tmp)-1-j)*tmp+y][tmp*i+x];
//                System.out.println((((1<<n)/tmp)-1-x/tmp));
                where[0] = (((1<<n)/tmp)-1-x/tmp)*tmp+y%tmp;
                where[1] = (y/tmp)*tmp+x%tmp;
//                where[0] = ((1<<n)/tmp-1-x/tmp)*tmp
                break;
            case 8:
                where[1] = (((1<<n)/tmp)-1-y/tmp)*tmp+x%tmp;
                where[0] = (x/tmp)*tmp+y%tmp;
                break;

        }
        return where;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[(1<<n)][(1<<n)];
        for (int i = 0; i < (1<<n); i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < (1<<n); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k, l;
        int[][] input = new int[r][2];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            input[i][0] = k;
            input[i][1] = l;
        }

        int[] ans;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < (1 << n); j++) {
//                System.out.print(i+" -> ");
                ans = solution(0, input, new int[]{i,j});
                sb.append(arr[ans[0]][ans[1]]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}