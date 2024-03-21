import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    /*
    1. 몬스터 복제 시도
    - 현재 위치에서 자신과 같은 방향의 몬스터 복제
    - 부화되지 않은 상태로 움직이지 못함, 동일한 방향
    2. 몬스터 이동
    - 자신의 방향대로 한칸 이동
    - 이동방향에 몬스터/팩맨/격자 벗어나면 반시계 방향으로 45도 회전 후 방향 판단
    - 8방향 다 갈 수 없다면 움직이지 않음
    3. 팩맨 이동
    - 총 3칸 이동
    - 각 이동마다 상하좌우의 선택지
    - 4^3의 경우의 수 = 64개의 경우의 수
    - 몬스터를 가장 많이 먹을 수 있는 방향으로 움직임
    - 상 하 좌 우의 우선순위
    - 이동할 때 이동하는 칸에 있는 몬스터는 모두 먹고, 그 자리에 몬스터의 시체를 남김
    - 알/움직이기 전에 함께 있었던 몬스터는 먹지 않음
    4. 몬스터 시체 소멸
    - 시체는 2턴동안만 유지, 시체소멸까지는 두 턴이 필요
    5. 몬스터 복제 완성
    - 알 형태였던 몬스터 부화


    어떻게 풀지
    복제 정보 저장 -> 나중에 반영해야 함
    몬스터 이동은 이동
    팩맨 이동은 bfs로 64개 다 하는게 맞을듯
    시체는 따로 저장해놨다가 삭제 (최대 3칸의 정보)
    복제 반영
     */
    static ArrayDeque<Monster>[][] mArr;
    static int[][] dArr, mCnt;
    static int cy, cx;
    static ArrayDeque<Monster> monsters;
    static ArrayDeque<Monster> eggs;
    static ArrayDeque<Monster>[] dead;

    // 몬스터 이동방향, 북쪽부터 반시계
//    static int[] mdy = {-1, -1, 0, 1, 1, 1, 0, -1};
//    static int[] mdx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] mdy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] mdx = {-1, -1, 0, 1, 1, 1, 0, -1};


    // 팩맨 이동방향, 상좌하우
    static int[] cdy = {-1, 0, 1, 0};
    static int[] cdx = {0, -1, 0, 1};
    static int eatMax;

    static class Monster {
        int y;
        int x;
        int d;

        Monster(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    static void layEgg() {
//        mPrint();
        int mSize; Monster curr;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                mSize = mArr[i][j].size();
                mCnt[i][j] = mSize;
                while(mSize-->0) {
                    curr = mArr[i][j].pollFirst();
                    eggs.offerLast(new Monster(curr.y, curr.x, curr.d));
                    mArr[i][j].offerLast(curr);
                }
            }
        }
//        System.out.println("eggs "+eggs.size());
    }

    static void mMove() {
//        System.out.println("mmove");
        int mSize, ny, nx, nd; Monster curr;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                mSize = mCnt[i][j];
                while(mSize-->0) {
                    curr = mArr[i][j].pollFirst();
                    for (int d = 0; d < 8; d++) {
                        nd = (curr.d-d+8)%8;
                        ny = curr.y+mdy[nd];
                        nx = curr.x+mdx[nd];
                        if(dArr[ny][nx] != 0 || (cy==ny&&cx==nx)) continue;
                        curr.y = ny; curr.x = nx; curr.d = nd;
                        break;
                    }
                    mArr[curr.y][curr.x].offerLast(curr);
                }
            }
        }
//        System.out.println("monster Moved");
//        mPrint();
    }
    static void mPrint() {
//        System.out.println("mPrint");
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                System.out.print(mArr[i][j].size()+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static void pMove() {

        int[] movement = new int[3];
        int[] best = new int[3];
        int[][] visited = new int[6][6];
        eatMax = -1;

        //상좌하우
        int ny, nx;
        for (int i = 0; i < 4; i++) {
            ny = cy+cdy[i]; nx = cx+cdx[i];
            if(ny<1||nx<1||4<ny||4<nx) continue;
            movement[0] = i;
            visited[cy+cdy[i]][cx+cdx[i]] ++;
            _moveStep(+1, cy+cdy[i], cx+cdx[i], movement, 0, best, visited);
            visited[cy+cdy[i]][cx+cdx[i]] --;
        }

//        System.out.println(Arrays.toString(best)+ +eatMax);

        for (int i = 0; i < 3; i++) {
            cy += cdy[best[i]];
            cx += cdx[best[i]];
            if(!mArr[cy][cx].isEmpty()){
                dArr[cy][cx] = 3;
                mArr[cy][cx].clear();
            }
        }
//        System.out.println(cy+ " "+cx);
    }

    static void _moveStep(int cnt, int y, int x, int[] movement, int eat, int[] best, int[][] visited) {
        if (cnt==3){
            if(eatMax < eat+(visited[y][x]>1?0:mArr[y][x].size())) {
                eatMax = eat+(visited[y][x]>1?0:mArr[y][x].size());
                best[0] = movement[0]; best[1] = movement[1]; best[2] = movement[2];
//                System.out.println(Arrays.toString(best)+" "+eatMax);
            }
            return;
        }
        int ny, nx;
        for (int i = 0; i < 4; i++) {
            ny = y+cdy[i]; nx = x+cdx[i];
            if(ny<1||nx<1||4<ny||4<nx) continue;
            movement[cnt] = i;
            visited[y+cdy[i]][x+cdx[i]] ++;
            _moveStep(cnt+1, y+cdy[i], x+cdx[i], movement, eat+(visited[y][x]>1?0:mArr[y][x].size()), best, visited);
            visited[y+cdy[i]][x+cdx[i]] --;
        }
    }

    static void dead() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if(dArr[i][j]>0) dArr[i][j]--;
            }
        }
    }

    static void babyMonster() {
        Monster curr;
        while(!eggs.isEmpty()) {
            curr = eggs.pollFirst();
            mArr[curr.y][curr.x].offerLast(curr);
        }
    }
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        //전체 맵
        mArr = new ArrayDeque[6][6];
        mCnt = new int[6][6];
        dArr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                mArr[i][j] = new ArrayDeque<>();
            }
            dArr[0][i] = -1;
            dArr[5][i] = -1;
            dArr[i][0] = -1;
            dArr[i][5] = -1;
        }

        
        // 몬스터 입력 받기
        monsters = new ArrayDeque<>();
        eggs = new ArrayDeque<>();

        int my, mx, md;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            my = Integer.parseInt(st.nextToken());
            mx = Integer.parseInt(st.nextToken());
            md = Integer.parseInt(st.nextToken())-1;
            mArr[my][mx].offerLast(new Monster(my, mx, md));
        }

        //팩맨 위치
        st = new StringTokenizer(br.readLine());
        cy = Integer.parseInt(st.nextToken());
        cx = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
//            System.out.println(cy+" "+cx);
            layEgg();
            mMove();
            pMove();
            dead();
            babyMonster();
        }
//        mPrint();
        int answer=0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                answer+=mArr[i][j].size();
            }
        }
        System.out.println(answer);
    }
}
/*
4 1
3 1
1 3 5
2 2 7
3 4 6
4 2 2

 */