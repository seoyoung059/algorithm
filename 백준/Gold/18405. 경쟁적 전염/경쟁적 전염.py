# 경쟁적 전염
from collections import deque
n,k = map(int, input().split())
arr = []
virus = []

for i in range(n):
    tmp = list(map(int, input().split()))
    for j,t in enumerate(tmp):
        if t!=0:
            virus.append([t, i, j, 0])
    arr.append(tmp)

s,x,y = map(int, input().split())

virus.sort()
q=deque(virus)

dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]

while q:
    v_num, cy, cx, sec = q.popleft()

    if sec >= s:
        break
    for i in range(4):
        ny = cy+dy[i]
        nx = cx+dx[i]
        if 0<=ny<n and 0<=nx<n and arr[ny][nx]==0:
            arr[ny][nx]=v_num
            q.append([v_num, ny, nx, sec+1])

print(arr[x-1][y-1])