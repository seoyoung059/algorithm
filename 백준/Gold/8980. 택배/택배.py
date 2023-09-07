n, c = map(int, input().split())
m = int(input())
datas = [list(map(int, input().split())) for _ in range(m)]
datas.sort()

carrying = [0] * (n+1)
available = c
ans = 0
curr = 1
idx = 0
while curr < n+1:
    ans += carrying[curr]
    available += carrying[curr]
    carrying[curr]=0
    if len(datas)>0:
        if curr == datas[0][0]:
            d = datas.pop(0)
            carrying[d[1]] += min(available,d[2])
            available -= min(available,d[2])
            continue
    curr += 1

    
print(ans)