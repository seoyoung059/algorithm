n = int(input())
k = int(input())
sensors = list(map(int, input().split()))
sensors.sort()
gap = [(sensors[i+1]-sensors[i]) for i in range(n-1)]
g = {}
for i in range(n-1):
    tmp = sensors[i+1]-sensors[i]
    if tmp in g.keys():
        g[tmp] += 1
    else:
        g[tmp]=1
arr = sorted(g.items())
ans = sum(gap)
cnt = k-1
while cnt > 0:
    if len(arr) <= 0:
        break
    tmp = min(cnt, arr[-1][1])
    cnt -= tmp
    ans -= tmp * arr[-1][0]
    arr.pop()
print(ans)