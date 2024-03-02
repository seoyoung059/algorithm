

# 물고기 m마리, 상어 1마리
# 처음 아기 상어 크기는 2
# 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 지나갈 수 있음
# 자신의 크기보다 작은 물고기만을 먹을 수 있음
# 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가한다.

from collections import deque


def bfs(sy, sx, sec, size, num):
    visited = [[0]*n for i in range(n)]
    visited[sy][sx] = 1
    start_sec = sec
    q = deque()
    # y좌표, x좌표, 시간, 크기, 먹은수
    q.append([sy, sx, sec, size, num])

    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]

    fin_sec = float('INF')
    eatable_fish = []
    while q:
        # print(q)
        cy, cx, sec, size, num = q.popleft()
        if sec > fin_sec:
            break

        # 4 방향에 대하여 bfs
        for i in range(4):
            ny = cy+dy[i]
            nx = cx+dx[i]

            if 0<=ny<n and 0<=nx<n and not visited[ny][nx]:
                if space[ny][nx] in [0, size]:
                    q.append([ny,nx,sec+1, size, num])
                    visited[ny][nx]=1
                elif 0< space[ny][nx] < size:
                    # print("냠냠")
                    eatable_fish.append([ny, nx, sec+1, size, num+1])
                    fin_sec = sec
                else:
                    continue
    
    if len(eatable_fish)>0:
        eatable_fish.sort(key=lambda x: [x[0], x[1]])
        tmp = eatable_fish[0]
        fish_num[space[tmp[0]][tmp[1]]]-=1
        space[tmp[0]][tmp[1]]=0
        # print("먹은 물고기",eatable_fish)
        return eatable_fish[0]
    else:
        return [-1, -1, start_sec, size, num]


n = int(input())
space = []
fish_num = [0]*(6+1)
shark_size = 2

for i in range(n):
    tmp = list(map(int, input().split()))
    for j, t in enumerate(tmp):
        if 0<t<9:
            fish_num[t]+=1
        if t == 9:
            sy, sx = i,j
            tmp[j]=0
    space.append(tmp)

cy, cx, sec, size, num = sy, sx, 0, 2, 0

while True:
    if size==num:
        size+=1
        num=0
    if sum(fish_num[:size])==0:
        # print('먹을 수 있는 물고기 없음')
        break
    # print(cy, cx, sec, size, num)
    cy, cx, sec, size, num = bfs(cy, cx, sec, size, num)
    if cy < 0:
        break
# print(cy, cx, sec, size, num)
print(sec)