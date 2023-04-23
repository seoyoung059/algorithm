import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import deque

def dfs(g,v,visited,group):
    visited[v]=group
    new_group=1+group%2
    ans = True
    for i in g[v]:
        if visited[i]==0:
            ans = dfs(g,i,visited,new_group)
            if not ans:
                return False
        elif visited[i]==group:
            return False
    return ans
    
    
k = int(input())

for _ in range(k):
    v,e = map(int, input().split())
    g=[[] for i in range(v+1)]
    for i in range(e):
        a,b = map(int,input().split())
        g[a].append(b)
        g[b].append(a)

    visited=[0]*(v+1)
    for j in range(1,v+1):
        if visited[j]==0:
            answer = dfs(g,j,visited,1)
            if not answer:
                print("NO")
                break
    if answer:
        print("YES")