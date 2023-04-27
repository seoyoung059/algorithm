import sys
from collections import deque
input = sys.stdin.readline

def bfs(graph,virus,s,x,y):
    queue=deque(virus)
    while queue:
        # for i in graph:
        #     print(i)
        v_num,cy,cx,cnt=queue.popleft()
        # print(cnt,s)
        if cnt==s:
            print(graph[x-1][y-1])
            return
        for i in range(4):
            ny=cy+dy[i]
            nx=cx+dx[i]
            if 0<=ny<n and 0<=nx<n and graph[ny][nx]==0:
                graph[ny][nx]=v_num
                queue.append((v_num,ny,nx,cnt+1))
    print(graph[x-1][y-1])
    

n,k = map(int, input().split())
graph=[]
virus=[]
for i in range(n):
    row=list(map(int,input().split()))
    graph.append(row)
    for j in range(n):
        if row[j]!=0:
            virus.append((row[j],i,j,0))
s,x,y = map(int,input().split())
virus.sort()

dy = [0,0,1,-1]
dx = [1,-1,0,0]
bfs(graph,virus,s,x,y)
