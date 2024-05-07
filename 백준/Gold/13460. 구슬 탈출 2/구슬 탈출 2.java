import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static char[][] arr;
    static ArrayDeque<int[]> q;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        int[] hole = new int[2];
        int[] red = new int[2];
        int[] blue = new int[2];

        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                switch (arr[i][j]) {
                    case 'R':
                        red[0] = i;
                        red[1] = j;
                        arr[i][j] = '.';
                        break;
                    case 'B':
                        blue[0] = i;
                        blue[1] = j;
                        arr[i][j] = '.';
                        break;
                    case 'O':
                        hole[0] = i;
                        hole[1] = j;
                        break;
                }
            }
        }

        q = new ArrayDeque<>();
        q.offer(new int[]{red[0], red[1], blue[0], blue[1]});
        visited = new boolean[n][m][n][m];
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
        int qSize, ry, rx, by, bx, i, trace = 0;
        int[] curr;
        boolean found = false;
        loop:
        for (i = 0; i < 10; i++) {
            qSize = q.size();
            while (qSize-- > 0) {
                curr = q.pollFirst();
//                System.out.println(Arrays.toString(curr));
                if (curr[0] > curr[2]) {
                    // 위로 확인할땐 blue 먼저
                    ry = curr[0];
                    rx = curr[1];
                    by = curr[2];
                    bx = curr[3];
                    while (arr[by - 1][bx] == '.') by--;
                    while (arr[ry - 1][rx] == '.' && !(by == ry - 1 && bx == rx)) ry--;

                    if (arr[by - 1][bx] != 'O') {
                        if (arr[ry - 1][rx] == 'O') {
                            found = true;
                            break loop;
                        }
                        if (!visited[ry][rx][by][bx]) {
                            visited[ry][rx][by][bx] = true;
                            q.offerLast(new int[]{ry, rx, by, bx});
                        }
                    }

                    // 아래로 확인할 땐 red 먼저
                    ry = curr[0];
                    by = curr[2];
                    while (arr[ry + 1][rx] == '.') ry++;
                    while (arr[by + 1][bx] == '.' && !(ry == by + 1 && rx == bx)) by++;

                    if(arr[ry+1][rx]=='O' && !(ry==by+1 && rx==bx)){
                        found = true;
                        break loop;
                    }
                    if(arr[by+1][bx]!='O' && !visited[ry][rx][by][bx]) {
                        visited[ry][rx][by][bx] = true;
                        q.offerLast(new int[]{ry, rx, by, bx});
                    }

                } else {
                    // 위로 확인할땐 red 먼저
                    ry = curr[0];
                    rx = curr[1];
                    by = curr[2];
                    bx = curr[3];
                    while (arr[ry - 1][rx] == '.') ry--;
                    while (arr[by - 1][bx] == '.' && !(ry == by - 1 && bx == rx)) by--;
                    if(arr[ry-1][rx]=='O' && !(ry==by-1 && rx==bx)){
                        found = true;
                        break loop;
                    }
                    if(arr[by-1][bx]!='O' && !visited[ry][rx][by][bx]) {
                        visited[ry][rx][by][bx] = true;
                        q.offerLast(new int[]{ry, rx, by, bx});
                    }


                    // 아래로 확인할 땐 blue 먼저
                    ry = curr[0];
                    by = curr[2];
                    while (arr[by + 1][bx] == '.') by++;
                    while (arr[ry + 1][rx] == '.' && !(by == ry + 1 && rx == bx)) ry++;
                    if (arr[by + 1][bx] != 'O') {
                        if (arr[ry + 1][rx] == 'O') {
                            found = true;
                            break loop;
                        }
                        if (!visited[ry][rx][by][bx]) {
                            visited[ry][rx][by][bx] = true;
                            q.offerLast(new int[]{ry, rx, by, bx});
                        }
                    }


                }

                if (curr[1] > curr[3]) {
                    // 왼쪽으로 확인할 땐 blue 먼저
                    ry = curr[0];
                    rx = curr[1];
                    by = curr[2];
                    bx = curr[3];
                    while (arr[by][bx - 1] == '.') bx--;
                    while (arr[ry][rx - 1] == '.' && !(bx == rx - 1 && by == ry)) rx--;
                    if (arr[by][bx-1] != 'O') {
                        if (arr[ry][rx-1] == 'O') {
                            found = true;
                            break loop;
                        }
                        if (!visited[ry][rx][by][bx]) {
                            visited[ry][rx][by][bx] = true;
                            q.offerLast(new int[]{ry, rx, by, bx});
                        }
                    }


                    // 오른쪽으로 확인할 땐 red 먼저
                    rx = curr[1];
                    bx = curr[3];
                    while (arr[ry][rx + 1] == '.') rx++;
                    while (arr[by][bx + 1] == '.' && !(rx == bx + 1 && ry == by)) bx++;
//                    System.out.println(ry+" "+rx+" "+by+" "+bx);
                    if(arr[ry][rx+1]=='O' && !(rx==bx+1 && ry==by)){
                        found = true;
                        break loop;
                    }
                    if(arr[by][bx+1]!='O' && !visited[ry][rx][by][bx]) {
                        visited[ry][rx][by][bx] = true;
                        q.offerLast(new int[]{ry, rx, by, bx});
                    }


                } else {
                    ry = curr[0];
                    rx = curr[1];
                    by = curr[2];
                    bx = curr[3];
                    while (arr[ry][rx - 1] == '.') rx--;
                    while (arr[by][bx - 1] == '.' && !(rx == bx - 1 && by == ry)) bx--;
                    if(arr[ry][rx-1]=='O' && !(rx==bx-1 && ry==by)){
                        found = true;
                        break loop;
                    }
                    if(arr[by][bx-1]!='O' && !visited[ry][rx][by][bx]) {
                        visited[ry][rx][by][bx] = true;
                        q.offerLast(new int[]{ry, rx, by, bx});
                    }


                    rx = curr[1];
                    bx = curr[3];
//                    System.out.println(ry+" "+rx+" "+by+" "+bx);
                    while (arr[by][bx + 1] == '.') bx++;
                    while (arr[ry][rx + 1] == '.' && !(bx == rx + 1 && ry == by)) rx++;
                    if (arr[by][bx+1] != 'O') {
                        if (arr[ry][rx+1] == 'O') {
                            found = true;
                            break loop;
                        }
                        if (!visited[ry][rx][by][bx]) {
                            visited[ry][rx][by][bx] = true;
                            q.offerLast(new int[]{ry, rx, by, bx});
                        }
                    }


                }
            }
        }
        if(!found){
            System.out.println(-1);
        } else {
            System.out.println(i+1);
        }
    }


}