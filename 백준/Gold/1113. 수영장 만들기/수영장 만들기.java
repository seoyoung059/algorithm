import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    static boolean isValid(int y, int x){
        return (0<=y)&&(y<n)&&(0<=x)&&(x<m);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int height = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int cntCell, sum, ny, nx;
        int[] curr;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
                height |= (1 << arr[i][j]);
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        /*
            N, M은 50보다 작거나 같은 자연수
            높이는 1보다 크거나 같고 9보다 작거나 같은 자연수

            가장 낮은 높이부터 하는건 어떰? -> 이게 나을듯?
            어쨌든 가장 낮은 높이는 못채우으니까 그 다음부터 ㄱㄱ
            첫번째 예시)
                5으로 채울수 있는지 알아보기
                5보다 작은 칸에 대해서 bfs
                둘러쌓여있지 않다면 패스
                둘러쌓여있으면 안에는 5으로 채워서 해당 높이를 다시 카운트하는 일이 엎도록 한다.
                다 더하는것도 괜찮을듯?
            두번째 예시)
                9로 채울수 있는지 확인하기
                3, 5, 6
            세번째 예시)
                2, 5, 9로 가능
         */

        int answer = 0;
        boolean first = true; boolean outer = false;
        for (int h = 0; h < 10; h++) {
            if ((height & (1 << h)) == 0) continue;
            if (first) {
                first = false;
                continue;
            }
//            System.out.println("========="+h);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] < h) {
                        sum = arr[i][j];
                        cntCell = 0;
                        arr[i][j] = h;
                        outer = false;
                        q.offer(new int[]{i, j});
                        while (!q.isEmpty()) {
                            curr = q.poll();
                            cntCell++;
                            for (int k = 0; k < 4; k++) {
                                ny = curr[0]+dy[k];
                                nx = curr[1]+dx[k];
                                if(!isValid(ny,nx)) {
//                                    System.out.println("out "+ny+" "+nx);
                                    outer = true;
                                }
                                else if(arr[ny][nx]<h){
                                    sum+=arr[ny][nx];
                                    q.offer(new int[] {ny, nx});
                                    arr[ny][nx] = h;
                                }
                            }
                        }

                        if(!outer){
                            answer += cntCell*h - sum;
                        }
//                        System.out.println(""+outer+" "+cntCell+" "+sum);


//                        for (int z = 0; z < n; z++) {
//                            System.out.println(Arrays.toString(arr[z]));
//                        }
//                        System.out.println();
                    }
                }

            }
//            System.out.println(answer);

        }
        System.out.println(answer);
    }
}