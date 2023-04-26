import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**4)


def dfs(graph,start_y,start_x,visited):
  visited[start_y][start_x]=1
  for i in range(4):
    new_y=start_y+dy[i]
    new_x=start_x+dx[i]
    if 0<=new_y<n and 0<=new_x<m and graph[new_y][new_x]!=0:
      if not visited[new_y][new_x]:
        dfs(graph,new_y,new_x,visited)
        
def countIce(graph):
  cnt=0
  visited=[]
  for _ in range(n):
    visited.append([0]*(m))
  for i in range(n):
    for j in range(m):
      if graph[i][j]!=0 and not visited[i][j]:
        dfs(graph,i,j,visited)
        cnt+=1
        if cnt>1:
          return cnt
  return cnt



def bfs(graph,start_y,start_x):
  val=graph[start_y][start_x]
  for i in range(4):
    new_y=start_y+dy[i]
    new_x=start_x+dx[i]
    if 0<=new_y<n and 0<=new_x<m and graph[new_y][new_x]==0:
      val=max(0,val-1)
  return val

def melt(graph):
  new_graph=[]
  for _ in range(n):
    new_graph.append([0]*(m))
  for i in range(n):
    for j in range(m):
      if graph[i][j]!=0:
        new_graph[i][j]=bfs(graph,i,j)
  return new_graph
        
def sol(graph):
  years=0
  while True:
    graph=melt(graph)
    years+=1
    cnt = countIce(graph)
    if cnt!=1:
      break
  if cnt==0:
    print(0)
  elif cnt>1:
    print(years)

n,m = map(int,input().split())
graph=[]
for _ in range(n):
  graph.append(list(map(int,input().split())))

dy=[0,0,1,-1]
dx=[1,-1,0,0]

sol(graph)