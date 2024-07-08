import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    /*
    정사각형 지형
    1: 나무, 0: 빈칸
    상/하/좌/우/회전 가능
    - 나무 있으면 이동 불가
    - 회전 시 중심점을 중심으로 90도 회전, 정사각형 구역에 나무가 없어야함
    한번에 한칸씩만 이동
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+2][n+2];
        int[][] start  = new int[3][2];
        int[][] end = new int[3][2];
        String str;
        int sIdx=0, eIdx=0;
        for (int i = 0; i < n+2; i++) {
            arr[0][i] = 1;
            arr[n+1][i] = 1;
            arr[i][0] = 1;
            arr[i][n+1] = 1;
        }
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < n; j++) {
                switch (str.charAt(j)){
                    case 'B':
                        start[sIdx][0] = i+1;
                        start[sIdx++][1] = j+1;
                        arr[i+1][j+1] = 0;
                        break;
                    case 'E':
                        end[eIdx][0] = i+1;
                        end[eIdx++][1] = j+1;
                        arr[i+1][j+1] = 0;
                        break;
                    case '0':
                        arr[i+1][j+1] = 0;
                        break;
                    case '1':
                        arr[i+1][j+1] = 1;
                        break;
                }
            }
        }

//        for (int i = 0; i < n+2; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        int sy = start[1][0], sx = start[1][1];
        // 시작 방향 가로일때 1, 세로일때 0
        int sd = (start[0][0] == start[1][0])? 1:0;


        int ey = end[1][0], ex = end[1][1];
        // 끝 방향 가로일때 1, 세로일때 0
        int ed = (end[0][0] == end[1][0])? 1:0;

//        System.out.println("start "+sy+" "+sx+" "+sd);
//        System.out.println("end "+ey+" "+ex+" "+ed);

        boolean[][][] visited = new boolean[n+2][n+2][2];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sy, sx, sd});
        int[] curr; int cnt=0, qSize;
        boolean available;
        boolean find = false;
        loop1:
        while(!q.isEmpty()) {
//            System.out.println("========== "+cnt+" =======");
            qSize = q.size();
            cnt++;
            loop2:
            while(qSize-- > 0){
                curr = q.pollFirst();

                // 상
                available = true;
                if(curr[0]-1 < 0 || visited[curr[0]-1][curr[1]][curr[2]]) {
                    available = false;
                }
                else if(curr[2] == 1) {
                    // 가로일때 위의 세칸 다 확인
                    for(int i=-1; i<=1; i++){
                        if(arr[curr[0]-1][curr[1]+i]==1){
                            available = false;
                            break;
                        }
                    }
                }
                else {
                    if(curr[0]-2 < 0){
                        available = false;
                    }
                    // 세로일때 위의 한칸만 확인
                    else if(arr[curr[0]-2][curr[1]]==1)
                        available = false;
                }
                if(available){
                    if(curr[0]-1==ey && curr[1]==ex && curr[2] == ed) {
                        find = true;
                        break loop1;
                    }
                    q.offerLast(new int[] {curr[0]-1, curr[1], curr[2]});
                    visited[curr[0]-1][curr[1]][curr[2]] = true;
                }


                // 하
                available = true;
                if(curr[0]+1 >= n+2 || visited[curr[0]+1][curr[1]][curr[2]]) {
                    available = false;
                }
                else if(curr[2] == 1) {
                    // 가로일때 아래의 세칸 다 확인
                    for(int i=-1; i<=1; i++){
                        if(arr[curr[0]+1][curr[1]+i]==1){
                            available = false;
                            break;
                        }
                    }
                }
                else {
                    if(curr[0]+2 >= n+2){
                        available = false;
                    }
                    // 세로일때 아래의 한칸만 확인
                    else if(arr[curr[0]+2][curr[1]]==1)
                        available = false;
                }
                if(available){
                    if(curr[0]+1==ey && curr[1]==ex && curr[2] == ed) {
                        find = true;
                        break loop1;
                    }
                    q.offerLast(new int[] {curr[0]+1, curr[1], curr[2]});
                    visited[curr[0]+1][curr[1]][curr[2]] = true;
                }

                // 좌
                available = true;
                if(curr[1]-1 < 0 || visited[curr[0]][curr[1]-1][curr[2]]) {
                    available = false;
                }
                else if(curr[2] == 0) {
                    // 세로일때 좌측의 세칸 다 확인
                    for(int i=-1; i<=1; i++){
                        if(arr[curr[0]+i][curr[1]-1]==1){
                            available = false;
                            break;
                        }
                    }
                }
                else {
                    if(curr[1]-2 < 0){
                        available = false;
                    }
                    // 가로일때 맨 왼쪽의 한칸만 확인
                    else if(arr[curr[0]][curr[1]-2]==1)
                        available = false;
                }
                if(available){
                    if(curr[0]==ey && curr[1]-1==ex && curr[2] == ed) {
                        find = true;
                        break loop1;
                    }
                    q.offerLast(new int[] {curr[0], curr[1]-1, curr[2]});
                    visited[curr[0]][curr[1]-1][curr[2]] = true;
                }

                // 우
                available = true;
                if(curr[1]+1 >= n+2 || visited[curr[0]][curr[1]+1][curr[2]]) {
                    available = false;
                }
                else if(curr[2] == 0) {
                    // 세로일때 오른쪽의 세칸 다 확인
                    for(int i=-1; i<=1; i++){
                        if(arr[curr[0]+i][curr[1]+1]==1){
                            available = false;
                            break;
                        }
                    }
                }
                else {
                    if(curr[1]+2 >= n+2){
                        available = false;
                    }
                    // 세로일때 아래의 한칸만 확인
                    else if(arr[curr[0]][curr[1]+2]==1)
                        available = false;
                }
                if(available){
                    if(curr[0]==ey && curr[1]+1==ex && curr[2] == ed) {
                        find = true;
                        break loop1;
                    }
                    q.offerLast(new int[] {curr[0], curr[1]+1, curr[2]});
                    visited[curr[0]][curr[1]+1][curr[2]] = true;
                }

                // 회전
                // 중복 확인
                if(visited[curr[0]][curr[1]][1-curr[2]]) continue;
                // 나무 확인
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if(arr[curr[0]+i][curr[1]+j]==1)
                            continue loop2;
                    }
                }
                if(curr[0]==ey && curr[1]==ex && 1-curr[2] == ed) {
                    find = true;
                    break loop1;
                }
                q.offerLast(new int[] {curr[0], curr[1], 1-curr[2]});
                visited[curr[0]][curr[1]][1-curr[2]] = true;
            }

//            for(int[] a: q){
//                System.out.print(Arrays.toString(a));
//            }
//            System.out.println();
        }
        System.out.println(find?cnt:0);

    }
}