# 감시 피하기
from itertools import combinations


n = int(input())
hallway = []
teacher = []
empty = []
for i in range(n):
    tmp = list(input().split())
    for j, t in enumerate(tmp):
        if t == 'T':
            teacher.append([i,j])
        elif t=='X':
            empty.append([i,j])
    hallway.append(tmp)

arr = list(combinations(empty, 3))

dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]
def sol(a):
    answer = True
    for ty, tx in teacher:
        if not answer:
            break
        i = 0
        while i<4 and answer:
            k=1
            ny = ty
            nx = tx
            while True:
                ny += dy[i]
                nx += dx[i]
                if 0<=ny<n and 0<=nx<n and [ny,nx] not in a:
                    if hallway[ny][nx]=='S':
                        # print(ny, nx)
                        answer = False
                        break
                else:
                    break
            i+=1
    return answer

ans = False
for a in arr:
    if sol(a):
        ans = True
if ans:
    print('YES')
else:
    print('NO')        