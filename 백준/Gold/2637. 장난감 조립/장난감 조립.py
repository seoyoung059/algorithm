import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())

g=[]
for _ in range(n+1):
    g.append([0]*(n+1))

for _ in range(m):
    x,y,k = map(int,input().split())
    g[y][x]=k
    
answer=[0]*(n+1)
answer[-1]=1
visited=[False]*(n+1)
order=deque()

def dfs(g,s,visited):
    global order
    visited[s]=True

    for i in range(1,n+1):
        if visited[i]==0 and g[s][i]!=0:
            dfs(g,i,visited)
    order.append(s)
    
def dfs_all(g,visited,n):
    for i in range(1,n+1):
        if visited[i]==0:
            dfs(g,i,visited)
            
dfs_all(g,visited,n)

while order:
  a=order.popleft()
  basic=True
  for i in range(1,n+1):
    if g[i][a]!=0:
      basic=False
    answer[i]+=answer[a]*g[i][a]
  if not basic: answer[a]=0
    

for i in range(len(answer)):
  if answer[i]!=0:
    print(i,answer[i])