import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static class Piece {
        int y;
        int x;
        int dir;
        int top;
        int cnt;

        Piece(int i, int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.top = i;
            this.cnt = 1;
        }

        @Override
        public String toString() {
            return (""+ this.cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] color = new int[n + 2][n + 2];
        Piece[][] board = new Piece[n + 2][n + 2];
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};

        for (int i = 0; i < n + 2; i++) {
            color[0][i] = 2;
            color[n + 1][i] = 2;
            color[i][0] = 2;
            color[i][n + 1] = 2;
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Piece[] pieces = new Piece[k];
        int y, x, d;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()) - 1;
            pieces[i] = new Piece(i, y, x, d);
            board[y][x]=pieces[i];
        }

        int ny, nx, nd, top, cnt;
        Piece tmp;
        int answer = -1;
        loop:
        for (int t = 1; t < 1001; t++) {
            for (int i = 0; i < k; i++) {
                if (pieces[i].cnt==0) continue;
                y = pieces[i].y;
                x = pieces[i].x;
                d = pieces[i].dir;
                top = pieces[i].top;
                cnt = pieces[i].cnt;

                ny = y + dy[d];
                nx = x + dx[d];

                switch (color[ny][nx]) {
                    case 0:
                        if(board[ny][nx] == null){
                            board[ny][nx] = pieces[i];
                            pieces[i].y = ny;
                            pieces[i].x = nx;
                        } else {
                            pieces[i].cnt = 0;
                            board[ny][nx].top = top;
                            board[ny][nx].cnt += cnt;
                        }
                        board[y][x] = null;
                        break;
                    case 1:
                        if(board[ny][nx] == null){
                            board[ny][nx] = pieces[top];
                            pieces[i].cnt = 0;
                            pieces[top].y = ny;
                            pieces[top].x = nx;
                            pieces[top].cnt = cnt;
                            pieces[top].top = i;
                        } else {
                            pieces[i].cnt = 0;
                            board[ny][nx].top = i;
                            board[ny][nx].cnt += cnt;
                        }
                        board[y][x] = null;
                        break;
                    case 2:
                        nd = d + ((d % 2 == 0) ? +1 : -1);
                        ny = y + dy[nd];
                        nx = x + dx[nd];
                        if (color[ny][nx] == 2) {
                            pieces[i].dir = nd;
                        } else {
                            pieces[i].dir = nd;
                            i--;
                        }
                        break;
                }
                if (board[ny][nx] != null && board[ny][nx].cnt >= 4) {
                    answer = t;
                    break loop;
                }


            }

        }
        System.out.println(answer);
    }
}