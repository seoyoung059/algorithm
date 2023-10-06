# 연구소
# 백준 14502
import sys
from itertools import combinations
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().split())
lab = []
empty = []
virus = []

for i in range(n):
    arr = list(map(int, input().split()))
    for j, a in enumerate(arr):
        if a==0:
            empty.append([i,j])
        elif a==2:
            virus.append([i,j])
    lab.append(arr)

# print(empty)
# print(virus)

arr = list(combinations(empty,3))

answer = n*m

def bfs(a):
    visited=[[0]*m for _ in range(n)]
    q = deque()
    for v in virus:
        q.append(v)
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    tmp = 0
    while q:
        cy, cx = q.popleft()
        visited[cy][cx]=1
        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]

            if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0:
                visited[ny][nx]=1
                if lab[ny][nx]==1 or [ny,nx] in a:
                    continue
                elif lab[ny][nx]==0:
                    tmp+=1
                    q.append([ny,nx])
    return tmp

for a in arr:
    answer = min(bfs(a), answer)

print(len(empty)-answer-3)