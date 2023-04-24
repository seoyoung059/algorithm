import sys
from collections import deque

n,m=map(int,sys.stdin.readline().split())
maze=[]
for _ in range(n):
    maze.append(sys.stdin.readline().rstrip())
    

dy=[0,1,0,-1]
dx=[1,0,-1,0]
def bfs(y,x,visited):
    cnt=1
    visited[y][x]=1
    queue = deque([(y,x)])
    while len(queue)>0:
        cy,cx = queue.popleft()
        for i in range(4):
            ny=cy+dy[i]
            nx=cx+dx[i]
            if 0<=nx<m and 0<=ny<n:
                if visited[ny][nx]==0 and maze[ny][nx]=='1':
                    visited[ny][nx]=visited[cy][cx]+1
                    # print(ny,nx,visited[ny][nx])
                    queue.append((ny,nx))
                    # bfs(ny,nx,visited,cnt+1)
                    
visited=[]
for k in range(n):
    visited.append([0]*m)
    
bfs(0,0,visited)
print(visited[n-1][m-1])