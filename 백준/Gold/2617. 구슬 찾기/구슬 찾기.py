import sys
input = sys.stdin.readline

def dfs_f(g,s,visited):
  global cnt_f
  visited[s]=1
  for i in g[s]:
    if visited[i]==0:
      visited[i]=1
      dfs_f(g,i,visited)
      cnt_f+=1

def dfs_b(g,s,visited):
  global cnt_b
  visited[s]=1
  for i in g[s]:
    if visited[i]==0:
      visited[i]=1
      dfs_b(g,i,visited)
      cnt_b+=1
    
n,m = map(int,input().split())
g_front=[]
g_back=[]
for _ in range(n+1):
  g_front.append([])
  g_back.append([])
for _ in range(m):
  a,b = map(int, input().split())
  g_back[a].append(b)
  g_front[b].append(a)

ans=0
for i in range(1,n+1):
  visited_front=[0]*(n+1)
  visited_back=[0]*(n+1)
  cnt_f=0
  cnt_b=0
  dfs_f(g_front,i,visited_front)
  dfs_b(g_back,i,visited_back)
  if  cnt_f > n//2 or cnt_b > n//2:
    ans+=1
print(ans)