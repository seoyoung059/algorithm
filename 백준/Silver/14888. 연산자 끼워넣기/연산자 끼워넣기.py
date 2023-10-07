# 연산자 끼워 넣기

n = int(input())
arr = list(map(int, input().split()))
a, b, c, d = map(int, input().split())

def sol(ans, i, a, b, c, d):
    if i == n:
        return [ans, ans]

    minval = +1000000000
    maxval = -1000000000    
    if a:
        maxtmp, mintmp = sol(ans+arr[i], i+1, a-1, b, c, d)
        minval = min(minval, mintmp)
        maxval = max(maxval, maxtmp)
    if b:
        maxtmp, mintmp = sol(ans-arr[i], i+1, a, b-1, c, d)
        minval = min(minval, mintmp)
        maxval = max(maxval, maxtmp)
    if c:
        maxtmp, mintmp = sol(ans*arr[i], i+1, a, b, c-1, d)
        minval = min(minval, mintmp)
        maxval = max(maxval, maxtmp)
    if d:
        if ans < 0:
            maxtmp, mintmp = sol(-(-ans//arr[i]), i+1, a, b, c, d-1)        
        else:
            maxtmp, mintmp = sol(ans//arr[i], i+1, a, b, c, d-1)
        minval = min(minval, mintmp)
        maxval = max(maxval, maxtmp)
    return [maxval, minval]


ans = sol(arr[0], 1, a,b,c,d)
for a in ans:
    print(a)