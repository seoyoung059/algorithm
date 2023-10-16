import copy
n, m, k = map(int, input().split())

maze = []
players = []

for i in range(n):
    arr  = list(map(int,input().split()))
    maze.append(arr)

for i in range(m):
    a,b = map(int, input().split())
    players.append([a-1, b-1])

ey, ex = map(int, input().split())
ey-=1
ex-=1



answer = 0
def player_move():
    global answer
    #플레이어는 벽이 없는 곳으로, 출구까지의 최단 거리가 가까운 곳으로 이동
    #움직일 수 있는 칸이 2개 이상이면, 상하로 움직이는 것이 우선
    left_players = len(players)
    for i in range(left_players):
        py, px = players.pop(0)
        
        # 출구가 플레이어보다 높은 y값이면 아래로 움직일 수 있나 확인
        if ey > py and maze[py+1][px] == 0:
            answer+=1
            if not(py+1==ey and px==ex):
                players.append([py+1, px])
        # 낮은 y값이면 위로 움직일 수 있나 확인
        elif ey < py and maze[py-1][px] == 0:
            answer+=1
            if not(py-1==ey and px==ex):
                players.append([py-1, px])
        # 높은 x값이면 오른쪽으로 움직일 수 있나 확인
        elif ex > px and maze[py][px+1] == 0:
            answer+=1
            if not(py==ey and px+1==ex):
                players.append([py, px+1])
        # 낮은 x값이면 왼쪽으로 움직일 수 있나 확인
        elif ex < px and maze[py][px-1] == 0:
            answer+=1
            if not(py==ey and px-1==ex):
                players.append([py, px-1])
        # 그 외에는 움직이지 않는다.
        else:
            players.append([py, px])


def find_rectangle():
    global ey, ex
    size = n
    left_y, left_x = 0,0
    for s in range(2, n+1):
        for i in range(n - s+1):
            for j in range(n - s+1):
                if i<= ey < i+s and j<= ex < j+s:
                    for py, px in players:
                        if i<= py < i+s and j<= px < j+s:
                            if s < size:
                                size = s
                                left_y, left_x = i,j
    return [size, left_y, left_x]

            
def turn_rectangle(size, left_y, left_x, maze):
    # 미로 회전
    new_maze = copy.deepcopy(maze)
    for i in range(size):
        for j in range(size):
            new_i = left_y+j
            new_j = left_x+size-1-i
            new_maze[new_i][new_j] = max(0, maze[left_y+i][left_x+j]-1)
    return new_maze

for i in range(k):
    # print(players)
    player_move()
    # print(players)
    if len(players)==0:
        break
    size, left_y, left_x = find_rectangle()
    maze = turn_rectangle(size, left_y, left_x, maze)
    # 출구 회전
    # print(ey, ex)
    ey, ex = left_y+ex-left_x, left_x+size+left_y-ey-1
    # print(ey, ex)
    # player 회전
    for i in range(len(players)):
        py, px = players[i]
        if left_y<=py<left_y+size and left_x<=px<left_x+size:
            # print(players[i])
            players[i] = [left_y+px-left_x, left_x+size+left_y-py-1]
            # print(players[i])

print(answer)
print(ey+1, ex+1)
