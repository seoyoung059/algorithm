import sys
import heapq

input = sys.stdin.readline

def bfs(maze,distance):
    dy = [0,-1,0,1]
    dx = [1,0,-1,0]
    distance[0][0]=0
    q=[]
    heapq.heappush(q,(0,0,0))
    while q:
        cy,cx,d = heapq.heappop(q)
        if distance[cy][cx] < d:
            continue
        for i in range(4):
            ny = cy+dy[i]
            nx = cx+dx[i]
            if 0<=ny<n and 0<=nx<n:
                nd=d
                if maze[ny][nx]=='0':
                    nd+=1
                if distance[ny][nx] > nd:
                    distance[ny][nx]=nd
                    heapq.heappush(q,(ny,nx,nd))

    print(distance[n-1][n-1])

n=int(input())
maze=[]
for _ in range(n):
    maze.append(input())
distance=[]
for _ in range(n):
    distance.append([n**2]*n)
bfs(maze,distance)