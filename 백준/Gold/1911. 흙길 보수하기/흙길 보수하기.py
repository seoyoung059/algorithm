n, l = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

arr.sort()
import math
tmp = 0
cnt = 0
for i in arr:
    if tmp < i[0]:
        tmp = i[0]
    c = math.ceil((i[1]-tmp)/l)
    tmp += c*l
    cnt += c
print(cnt)