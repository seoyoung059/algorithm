from collections import deque

n, m, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

tower_attack = [[-1]*m for _ in range(n)]
attacker = [0,0]
defencer = [0,0]


def attack():
    global arr, tower_attack, attacker
    power = 5001
    ay, ax = attacker
    for i in range(n):
        for j in range(m):
            if arr[i][j]>0:
                if arr[i][j] < power:
                    ay, ax = i,j
                    power = arr[i][j]
                elif arr[i][j] == power:
                    if tower_attack[i][j] > tower_attack[ay][ax]:
                        ay, ax = i,j
                        # power = arr[i][j]
                    elif tower_attack[i][j] == tower_attack[ay][ax]:
                        if i+j > ay+ax:
                            ay, ax = i,j
                            # power = arr[i][j]
                        elif i+j == ay+ax:
                            if j > ax:
                                ay, ax = i,j
    attacker = [ay, ax]

def defence():
    global arr, attacker, tower_attack, defencer
    power = 0
    ay, ax = attacker
    by, bx = defencer

    for i in range(n):
        for j in range(m):
            if i==ay and j==ax: continue
            if arr[i][j] > 0:
                if arr[i][j] > power:
                    by, bx = i,j
                    power = arr[i][j]
                elif arr[i][j]==power:
                    if tower_attack[i][j] < tower_attack[by][bx]:
                        by, bx = i,j
                        # power = arr[i][j]
                    elif tower_attack[i][j] == tower_attack[by][bx]:
                        if i+j < by+bx:
                            by, bx = i,j
                            # power = arr[i][j]
                        elif i+j == by+bx:
                            if j < bx:
                                by, bx = i,j
                                # power = arr[i][j]
    defencer = [by, bx]


def laser_attack():
    global arr, attacker, defencer, attack

    ay, ax = attacker
    by, bx = defencer

    q = deque()
    q.append([ay, ax,[]])

    dy = [0, 1, 0, -1]
    dx = [1, 0, -1, 0]
    visited = [[0] * m for i in range(n)]
    visited[ay][ax]=1
    while q:
        cy, cx, route = q.popleft()

        for i in range(4):
            ny = (cy + dy[i])%n
            nx = (cx + dx[i])%m

            if visited[ny][nx]==1: continue
            if arr[ny][nx]==0: continue

            if ny==by and nx == bx:
                arr[ny][nx]-=arr[ay][ax]
                for ry, rx in route:
                    arr[ry][rx] -= (arr[ay][ax])//2
                    attacked[ry][rx] = True
                return True
            
            tmp_route = route[:]
            tmp_route.append((ny, nx))
            visited[ny][nx]=1
            q.append([ny, nx, tmp_route])

    return False

def canon_attack():
    global arr, attacker, defencer, attacked
    ay, ax = attacker
    by, bx = defencer

    for i in range(by-1, by+2):
        for j in range(bx-1, bx+2):
            ny = i%n
            nx = j%m
            if ny==ay and nx==ax: continue
            if ny==by and nx==bx:
                arr[ny][nx]-=arr[ay][ax]
            else:
                arr[ny][nx]-=arr[ay][ax]//2
                attacked[ny][nx] = True

def fix():
    global arr, attacked, attacker, defencer
    cnt = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j]<0:
                arr[i][j]=0
            elif arr[i][j]>0:
                cnt+=1
                if attacked[i][j]: continue
                else:
                    arr[i][j]+=1
    if cnt <= 1:
        return True
    else:
        return False

def find_max():
    global arr
    max_val = 0
    for a in arr:
        max_val = max(max_val, max(a))
    return max_val


for i in range(k):
    attack()
    defence()
    attacked = [[False]*m for i in range(n)]


    ay, ax = attacker
    by, bx = defencer
    attacked[ay][ax]=True
    attacked[by][bx]=True

    arr[ay][ax]+=m+n
    tower_attack[ay][ax]=i
    if not laser_attack():
        canon_attack()

    if fix():
        break

answer= find_max()
print(answer)

