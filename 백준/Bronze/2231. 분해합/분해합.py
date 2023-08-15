n = int(input())
ans = 0
for i in range(n):
    num = str(i)
    sum = i
    for c in num:
        sum+=int(c)
    if sum == n:
        ans = i
        break
print(ans)