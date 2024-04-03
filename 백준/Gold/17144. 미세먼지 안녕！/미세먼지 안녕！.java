import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int sy=-1, sx=-1, sum = 0;

        int[][] arr = new int[r][c];
        int[][] newArr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==-1 && sy==-1){
                    sy = i; sx = j;
                }
                else if(arr[i][j]>0){
                    sum+=arr[i][j];
                }
            }
        }


        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int ny, nx, cnt, tmp, tmp2;
        int[][] tmpArr;
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    newArr[i][j] = 0;
                }
            }
            // 미세먼지 확산

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(arr[i][j]>0){
                        if(arr[i][j]/5>0){
                            cnt = 0;
                            for (int k = 0; k < 4; k++) {
                                ny = i+dy[k];
                                nx = j+dx[k];
                                if(ny<0||nx<0||r<=ny||c<=nx||arr[ny][nx]==-1) continue;
                                newArr[ny][nx]+=arr[i][j]/5;
                                cnt++;
                            }
                            newArr[i][j] += arr[i][j] - cnt*(arr[i][j]/5);
                        } else newArr[i][j] += arr[i][j];
                    }
                    else if(arr[i][j]==-1){
                        newArr[i][j] = -1;
                    }
                }
            }

            tmpArr = arr;
            arr = newArr;
            newArr = tmpArr;

//            for (int i = 0; i < r; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();

            //공기청정기 순환
            int cy1, cy2, cx1, cx2;
            if(sx < c-1){
                cy1 = sy - 1;
                cx1 = sx;
                sum-=arr[cy1][cx1];
                while(cy1-1 >= 0){
                    arr[cy1][cx1] = arr[cy1-1][cx1];
                    cy1--;
                }
                while(cx1+1 < c) {
                    arr[cy1][cx1] = arr[cy1][cx1+1];
                    cx1++;
                }
                while(cy1+1 <= sy) {
                    arr[cy1][cx1] = arr[cy1+1][cx1];
                    cy1++;
                }
                while(cx1-1 > sx) {
                    arr[cy1][cx1] = arr[cy1][cx1-1];
                    cx1--;
                }
                arr[cy1][cx1] = 0;

                cy2 = sy + 2;
                cx2 = sx;
                sum-=arr[cy2][cx2];
                while(cy2+1 < r) {
                    arr[cy2][cx2] = arr[cy2+1][cx2];
                    cy2++;
                }
                while(cx2+1 < c) {
                    arr[cy2][cx2] = arr[cy2][cx2+1];
                    cx2++;
                }
                while(cy2-1 >= sy+1){
                    arr[cy2][cx2] = arr[cy2-1][cx2];
                    cy2--;
                }
                while(cx2-1 > sx) {
                    arr[cy2][cx2] = arr[cy2][cx2-1];
                    cx2--;
                }
                arr[cy2][cx2] = 0;
            }

//            for (int i = 0; i < r; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();
        }
        System.out.println(sum);
    }
}