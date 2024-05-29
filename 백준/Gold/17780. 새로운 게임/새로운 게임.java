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

        boolean isOn;

        Piece (int y, int x, int dir){
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.isOn = false;
        }

        @Override
        public String toString() {
            return (this.y+" "+this.x+" "+this.dir+" "+this.isOn);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] color = new int[n+2][n+2];
        ArrayDeque<Piece>[][] board = new ArrayDeque[n+2][n+2];
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};

        for (int i = 0; i < n+2; i++) {
            color[0][i] = 2;
            color[n+1][i] = 2;
            color[i][0] = 2;
            color[i][n+1] = 2;
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new ArrayDeque<Piece>();
            }
        }

        Piece[] pieces = new Piece[k];
        int y, x, d;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken())-1;
            pieces[i] = new Piece(y, x, d);
            board[y][x].offerLast(pieces[i]);
        }

        int ny, nx, nd;
        Piece tmp;
        int answer = -1;
        loop: for (int t = 1; t < 1001; t++)  {
            for (int i = 0; i < k; i++) {
                if (pieces[i].isOn) continue;

                y = pieces[i].y;
                x = pieces[i].x;
                d = pieces[i].dir;

                ny = y + dy[d];
                nx = x + dx[d];

//                System.out.println(i+" "+color[ny][nx]);
                switch (color[ny][nx]) {
                    case 0:
                        while (!board[y][x].isEmpty()) {
                            tmp = board[y][x].pollFirst();
                            tmp.y = ny;
                            tmp.x = nx;
                            tmp.isOn = !board[ny][nx].isEmpty();
                            board[ny][nx].offerLast(tmp);
                        }
                        break;
                    case 1:
                        while (!board[y][x].isEmpty()) {
                            tmp = board[y][x].pollLast();
                            tmp.y = ny;
                            tmp.x = nx;
                            tmp.isOn = !board[ny][nx].isEmpty();
                            board[ny][nx].offerLast(tmp);
                        }
                        break;
                    case 2:
                        nd = (d / 2) * 2 + (1 - d % 2);
//                        System.out.println("change dir "+ d+" "+nd);
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
                if(board[ny][nx]!=null&&board[ny][nx].size()>=4){
                    answer = t;
                    break loop;
                }
            }
//            System.out.println(Arrays.toString(pieces));
        }
//        System.out.println(Arrays.toString(pieces));
        System.out.println(answer);
    }
}