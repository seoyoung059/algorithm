from collections import deque
n = int(input())

ans = 10**9
ingredient= [list(map(int, input().split())) for i in range(n)]
arr = []
for i in range(n):
  s,b = ingredient[i]
  ans = min(ans,abs(s-b))
  l = len(arr)
  for j in range(l):
    tmp = arr[j]
    new_s = tmp[0]*s
    new_b = tmp[1]+b
    ans = min(ans, abs(new_s-new_b))
    arr.append([new_s, new_b])
  arr.append([s,b])
print(ans)