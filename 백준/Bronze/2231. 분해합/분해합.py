n=int(input())
ans = 0

for i in range(n-1,-1,-1):
    get_str = str(n-i)
    sum=0
    for c in get_str:
        sum+=int(c)
    if sum + int(get_str) == n:
        ans = get_str
        break

print(ans)