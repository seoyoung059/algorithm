#공유기 설치

n,c = map(int, input().split())
arr = [int(input()) for _ in range(n)]
arr.sort()

s = 1
e = arr[-1]-arr[0]
ans = 0
while s <= e:
    mid = (s+e)//2
    
    min_val = float('INF')
    cnt = 1
    prev = arr[0]
    for i in range(1,n):
        if arr[i]-prev >= mid:
            min_val = min(min_val, arr[i]-prev)
            cnt+=1
            prev = arr[i]
    
    if cnt < c:
        e = mid -1
    else:
        s = mid +1
        ans = max(ans, min_val)

print(ans)

