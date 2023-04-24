import sys
from collections import deque
input = sys.stdin.readline

def sol(g,k,x,visited):
    # print(k)
    ans=[]
    visited[x]=0
    queue = deque([x])
    while len(queue)>0:
        c = queue.popleft()
        # print(c)
        for i in g[c]:
            if visited[i]==0 and i!=x:
                visited[i]=visited[c]+1
                if visited[i]==k:
                    ans.append(i)
                queue.append(i)
    if not ans:
        print(-1)
    else:
        ans.sort()
        for _ in ans:
            print(_)
            
n,m,k,x = map(int,input().split())
g=[[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    g[a].append(b)
    

visited=[0]*(n+1)
sol(g,k,x,visited)