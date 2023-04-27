import sys
input = sys.stdin.readline

n,m = map(int,input().split())
floor=[]
for _ in range(n):
    floor.append(list(input().rstrip()))
    
dy = [0,0,1,-1]
dx = [1,-1,0,0]
def dfs(floor,cy,cx,visited):
    visited[cy][cx]=True
    if floor[cy][cx] == '-':
        for i in range(0,2):
          ny = cy+dy[i]
          nx = cx+dx[i]
          if 0<=ny<n and 0<=nx<m:
             if floor[ny][nx]=='-' and not visited[ny][nx]:
                dfs(floor,ny,nx,visited)
    else:
       for i in range(2,4):
          ny = cy+dy[i]
          nx = cx+dx[i]
          if 0<=ny<n and 0<=nx<m:
             if floor[ny][nx]=='|'and not visited[ny][nx]:
                dfs(floor,ny,nx,visited)


def sol(floor,n,m):
   cnt=0
   visited=[]
   for i in range(n):
      visited.append([False]*m)
   for i in range(n):
      for j in range(m):
         if not visited[i][j]:
            dfs(floor,i,j,visited)
            cnt+=1
   print(cnt)

sol(floor,n,m)