from collections import deque

#n*n 격자, m명의 사람
n, m = map(int, input().split())

town = []
stores = []
people = []
not_arrived = m

for i in range(n):
    town.append(list(map(int, input().split())))

for i in range(m):
    a,b = map(int, input().split())
    stores.append((a-1,b-1))
    people.append([-1,-1])

# -1: 지나갈 수 없는 칸
# 베이스 캠프에 들어간 이후, 편의점에 도착한 이후 베이스 캠프와 편의점이 해당하는 칸은 지나갈 수 없음

d = [(-1, 0), (0, -1), (0, 1), (1, 0)]

def find_basecamp(p):
    sy, sx = stores[p]

    q = deque()
    q.append((sy, sx))

    visited = [[False]*n for _ in range(n)]
    visited[sy][sx]=True
    while q:
        cy, cx = q.popleft()

        for dy, dx in d:
            ny = cy+dy
            nx = cx+dx

            if 0<=ny<n and 0<=nx<n:
                if visited[ny][nx]:
                    continue
                if town[ny][nx]==-1:
                    continue
                if town[ny][nx]==1:
                    people[p]=[ny, nx]
                    # town[ny][nx]=-1 사람들이 모두 이동한 뒤에 해당 칸을 지나갈 수 없어짐
                    cannotgo.append([ny, nx])
                    return [ny, nx]
                visited[ny][nx]=True
                q.append((ny, nx))

    print('something wrong!')


def person_move(p):
    global not_arrived
    py, px = people[p]
    sy, sx = stores[p]

    q = deque()
    q.append((py, px, [0,0]))

    visited = [[False]*n for _ in range(n)]
    visited[py][px]=True

    while q:
        cy, cx, first_step = q.popleft()

        for dy, dx in d:
            ny = cy+dy
            nx = cx+dx

            if 0<=ny<n and 0<=nx<n:
                if visited[ny][nx]: continue
                if town[ny][nx]==-1: continue
                # if ny==sy and nx==sx:
                #     not_arrived-=1
                #     people[p] = [-1, -1] #도착
                #     cannotgo.append([ny, nx])
                #     return True
                if cy==py and cx==px:
                    if ny==sy and nx==sx:
                        not_arrived-=1
                        people[p] = [-1, -1] #도착
                        cannotgo.append([ny, nx])
                        return True
                    else:
                        visited[ny][nx]=True
                        q.append((ny, nx, [ny, nx]))
                else:
                    if ny==sy and nx==sx:
                        people[p] = first_step
                        return True
                    else:
                        visited[ny][nx]=True
                        q.append((ny, nx, first_step))
    return False




t = 0
cannotgo = [] # 폐쇄된 칸 리스트
while not_arrived>0:

    # step 1,2 : 격자 위에 있는 모든 사람들 움직임
    for i in range(m):
        if people[i][0]!=-1:
            person_move(i)
    
    # step0: cannotgo 리스트에 있는 칸 폐쇄
    # for y, x in cannotgo:
    #     town[y][x] = -1
    while cannotgo:
        y,x = cannotgo.pop()
        town[y][x]=-1

    
    # step 3: 
    if t < m:
        find_basecamp(t)

    while cannotgo:
        y,x = cannotgo.pop()
        town[y][x]=-1


    # print('####  t=',t,'  #####')
    # for y in range(n):
    #     print(town[y])
    # print(people)
    t+=1

print(t)
