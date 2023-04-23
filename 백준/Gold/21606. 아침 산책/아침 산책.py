import sys

n = int(sys.stdin.readline())
a = input()

g=[[] for i in range(n+1)]
for i in range(1,n):
    k,l = map(int,sys.stdin.readline().split())
    g[k].append(l)
    g[l].append(k)
    
def dfs(g,s,a,visited):
    visited[s]=True
    cnt=0
    for i in g[s]:
        if not visited[i]:
            if a[i-1]=='0':
                cnt+=dfs(g,i,a,visited)
            else:
                cnt+=1
    return cnt

def sol(n,g,a):
    cnt=0
    for i in range(1,n+1):
        if a[i-1]=='1':
            visited=[False]*(n+1)
            cnt+=dfs(g,i,a,visited)
    return cnt

print(sol(n,g,a))